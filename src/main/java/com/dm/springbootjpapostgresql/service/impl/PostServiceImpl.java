package com.dm.springbootjpapostgresql.service.impl;

import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import com.dm.springbootjpapostgresql.mapper.PostMapper;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.dm.springbootjpapostgresql.dto.PostDto;
import com.dm.springbootjpapostgresql.dto.PostResponse;
import com.dm.springbootjpapostgresql.exception.ResourceNotFoundException;
import com.dm.springbootjpapostgresql.model.Post;
import com.dm.springbootjpapostgresql.repository.PostRepository;
import com.dm.springbootjpapostgresql.service.PostService;

@Service
public class PostServiceImpl implements PostService{

    //private ModelMapper mapper;

    @Autowired
    private PostMapper postMapper;

    @Autowired
	private PostRepository postRepository;

    /* 
	public PostServiceImpl(PostRepository postRepository,ModelMapper mapper) {
		super();
		this.postRepository = postRepository;
        this.mapper = mapper;
	}*/

    @Override
    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // create Pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Post> posts = postRepository.findAll(pageable);

        // get content for page object
        List<Post> listOfPosts = posts.getContent();

        List<PostDto> content= listOfPosts.stream().map(post -> postMapper.mapToDTO(post)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(content);
        postResponse.setPageNo(posts.getNumber());
        postResponse.setPageSize(posts.getSize());
        postResponse.setTotalElements(posts.getTotalElements());
        postResponse.setTotalPages(posts.getTotalPages());
        postResponse.setLast(posts.isLast());

        return postResponse;
    }


    @Override
    public PostDto createPost(PostDto postDto) {


        // convert DTO to entity
        Post post = postMapper.mapToEntity(postDto);
        //post.setCategory(category);
        Post newPost = postRepository.save(post);

        // convert entity to DTO
        PostDto postResponse = postMapper.mapToDTO(newPost);
        return postResponse;
    }
	@Override
	public PostDto updatePost(PostDto postDto, long id) {
        // get post by id from the database
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));


        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post updatedPost = postRepository.save(post);
        return postMapper.mapToDTO(updatedPost);
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
            return postMapper.mapToDTO(post);
        }        
		


}
