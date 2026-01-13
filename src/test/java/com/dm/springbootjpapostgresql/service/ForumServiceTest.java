package com.dm.springbootjpapostgresql.service;

import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dm.springbootjpapostgresql.SpringBootJpaPostgresqlApplication;
import com.dm.springbootjpapostgresql.dto.CommentRecord;
import com.dm.springbootjpapostgresql.dto.PostRecord;

import io.hypersistence.utils.hibernate.type.json.internal.JacksonUtil;


@SpringBootTest
public class ForumServiceTest {

@Autowired
ForumService forumService;

private static final Logger logger = LoggerFactory.getLogger(SpringBootJpaPostgresqlApplication.class);

@Test
public void insertPost() {
    forumService.insertPostRecord(
    new PostRecord(
        //1L,
        null,
        "High-Performance Java Persistence2",
        "High-Performance Java Persistence-description",
        "High-Performance Java Persistence-content",
        LongStream.rangeClosed(1, 5)
            .mapToObj(i ->
                new CommentRecord(
                    null,
                    "prabhu",
                    "prabhu@gmail.com",
                    String.format("Good review nr. %d", i),
                    null,
                    null
                )
            )
            .toList(),
            null,
            null,
            null
    )
);    

}

@Test
public void findPostById() {
    PostRecord postRecord = forumService.findPostRecordById(1L);
    logger.info("PostRecord to JSON: {}", JacksonUtil.toString(postRecord));
}

// @Test
// private void mergePost() {
// String upatedPostRecordJSONSTring = """
//     {
//       "id": 1,
//       "title": "High-Performance Java Persistence, 2nd edition",
//       "comments": [
//         {
//           "id": 1,
//           "review": "Best book on JPA and Hibernate!"
//         },
//         {
//           "id": 2,
//           "review": "A must-read for every Java developer!"
//         }
//       ]
//     }
//     """;
  
// forumService.mergePostRecord(
//     JacksonUtil.fromString(
//         upatedPostRecordJSONSTring,
//         PostRecord.class
//     )
// );
// }

@Test
public void updatePostRecord() {
String upatedPostRecordJSONSTring = """
    {
      "id": 1,
      "title": "High-Performance Java Persistence, 2nd edition",
      "comments": [
        {
          "id": 1,
          "review": "Best book on JPA and Hibernate!"
        },
        {
          "id": 2,
          "review": "A must-read for every Java developer!"
        }
      ]
    }
    """;
  
forumService.updatePostRecord(
    JacksonUtil.fromString(
        upatedPostRecordJSONSTring,
        PostRecord.class
    )
);
}

}
