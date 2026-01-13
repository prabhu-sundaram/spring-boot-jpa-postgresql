package com.dm.springbootjpapostgresql.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

//import com.dm.springbootjpapostgresql.dto.CommentDto;
import com.dm.springbootjpapostgresql.dto.PostDto;
import com.dm.springbootjpapostgresql.dto.PostResponse;
import com.dm.springbootjpapostgresql.exception.ResourceNotFoundException;
import com.dm.springbootjpapostgresql.mapper.jpa.PostMapper;
import com.dm.springbootjpapostgresql.model.entity.Category;
import com.dm.springbootjpapostgresql.model.entity.Post;
import com.dm.springbootjpapostgresql.repository.jpa.CategoryRepository;
import com.dm.springbootjpapostgresql.repository.jpa.PostRepository;
import com.dm.springbootjpapostgresql.service.PostService;

@Service
public class PostServiceImpl implements PostService{

    //private ModelMapper mapper;

    @Autowired
    private PostMapper postMapper;

    // @Autowired
    // private CommentMapper commentMapper;

    @Autowired
	private PostRepository postRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    // public PostServiceImpl(PostRepository postRepository, ModelMapper mapper,
    //                        CategoryRepository categoryRepository) {
    //       this.postRepository = postRepository;
    //       this.mapper = mapper;
    //       this.categoryRepository = categoryRepository;
    // }

    @Override
    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // create Pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Post> pagePost = postRepository.findAll(pageable);

        // get content for page object
        //List<Post> listOfPosts = pagePost.getContent();

        //List<PostDto> content= listOfPosts.stream().map(post -> postMapper.mapToDTO(post)).collect(Collectors.toList());
        //List<PostDto> content= listOfPosts.stream().map(post -> postMapper.toDto(post)).collect(Collectors.toList());

        // PostResponse postResponse = new PostResponse();
        // postResponse.setContent(content);
        // postResponse.setPageNo(posts.getNumber());
        // postResponse.setPageSize(posts.getSize());
        // postResponse.setTotalElements(posts.getTotalElements());
        // postResponse.setTotalPages(posts.getTotalPages());
        // postResponse.setLast(posts.isLast());

        // return postResponse;
        return postMapper.toPostResponse(pagePost);
    }


    @Override
    public PostDto createPost(PostDto postDto) {

        Category category = categoryRepository.findById(postDto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", postDto.getCategoryId()));

        // convert DTO to entity
        //Post post = postMapper.mapToEntity(postDto);
        Post post = postMapper.toEntity(postDto);

        //post.setCategory(category);

        // Add comments to the post (ensure post ID is set)
        // if (postDto.getComments() != null) {
        //     for (CommentDto commentDto : postDto.getComments()) {
        //         Comment comment = commentMapper.mapToEntity(commentDto);
        //         comment.setPost(post); // Explicitly set the post reference
        //         post.getComments().add(comment);
        //     }
        // }

        // Save the post
        Post newPost = postRepository.save(post);

        // convert entity to DTO
        //PostDto postResponse = postMapper.mapToDTO(newPost);
        PostDto postResponse = postMapper.toDto(newPost);
        return postResponse;
    }

	@Override
	public PostDto updatePost(PostDto postDto, long id) {
        // get post by id from the database
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        Category category = categoryRepository.findById(postDto.getCategoryId())
                        .orElseThrow(() -> new ResourceNotFoundException("Category", "id", postDto.getCategoryId()));

        // post.setTitle(postDto.getTitle());
        // post.setDescription(postDto.getDescription());
        // post.setContent(postDto.getContent());
        // post.setCategory(category);

        postMapper.updatePostFromDto(postDto,post);
        Post updatedPost = postRepository.save(post);
        //return postMapper.mapToDTO(updatedPost);
        return postMapper.toDto(updatedPost);
	}    

    @Override
    public void deletePostById(long id) {
        // get post by id from the database
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepository.delete(post);
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        //return postMapper.mapToDTO(post);
        return postMapper.toDto(post);
    }        

    @Override
    public List<PostDto> getPostsByCategory(Long categoryId) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

        List<Post> posts = postRepository.findByCategoryId(categoryId);

        // return posts.stream().map((post) -> postMapper.mapToDTO(post))
        //         .collect(Collectors.toList());
        return posts.stream().map((post) -> postMapper.toDto(post))
                .collect(Collectors.toList());        
    }

  
}
