package com.dm.springbootjpapostgresql.repository.jpa;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BlogRepository {

    private final JdbcTemplate jdbcTemplate;

    public BlogRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Example: Primitive Input / Single Primitive OUT parameter
    public String getCategoryName(Long id) {
        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("BLOG_PKG")
                .withProcedureName("get_category_name");

        SqlParameterSource in = new MapSqlParameterSource().addValue("p_id", id);
        
        Map<String, Object> out = call.execute(in);
        // "p_name" matches the OUT parameter name in the Oracle Package
        return (String) out.get("P_NAME"); 
    }
    // Example 1: No input/Ref Cursor output (Get All Posts)
    public List<Map<String, Object>> getAllPosts() {
        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("BLOG_PKG")
                .withProcedureName("get_all_posts")
                .returningResultSet("p_cursor", new ColumnMapRowMapper());
        
        return (List<Map<String, Object>>) call.execute().get("p_cursor");
    }

    // Example 2: Primitive In/Out (Create Post)
    public Long createPost(String title, String desc, String content, Long catId) {
        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("BLOG_PKG")
                .withProcedureName("create_post");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_title", title)
                .addValue("p_desc", desc)
                .addValue("p_content", content)
                .addValue("p_cat_id", catId);

        Map<String, Object> out = call.execute(in);
        //return ((Number) out.get("p_new_id")).longValue();
        
    // Check for both lowercase and uppercase keys
    Object newId = out.get("p_new_id") != null ? out.get("p_new_id") : out.get("P_NEW_ID");

    if (newId == null) {
        throw new RuntimeException("Procedure executed but P_NEW_ID was not returned. Check procedure OUT parameter.");
    }

    return ((Number) newId).longValue();        
    }

    // Example 3: JSON Input/No output (Update Category)
    public void updateCategoryViaJson(String jsonString) {
        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("BLOG_PKG")
                .withProcedureName("update_category_json");

        call.execute(new MapSqlParameterSource("p_json_input", jsonString));
    }

    // Example 4: Primitive Input/Ref Cursor output (Get comments by post id)    
    public List<Map<String, Object>> getCommentsByPost(Long postId) {
        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("BLOG_PKG")
                .withProcedureName("GET_COMMENTS_BY_POST")
                // Explicitly map the Ref Cursor parameter "p_cursor"
                .returningResultSet("p_cursor", new ColumnMapRowMapper());
        
        Map<String, Object> out = call.execute(new MapSqlParameterSource("p_post_id", postId));
        return (List<Map<String, Object>>) out.get("p_cursor");
    }

    // Example: Primitive Input / No Output (Simple Delete)
    public void deletePost(Long id) {
        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("BLOG_PKG")
                .withProcedureName("delete_post");

        call.execute(new MapSqlParameterSource("p_id", id));
    }

    // Example: No Input / No Output (Delete All)
    public void deleteAllPosts() {
        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("BLOG_PKG")
                .withProcedureName("delete_all_posts");
                
        call.execute();
    }

}
