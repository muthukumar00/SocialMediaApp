package com.muthu.rest.webservice.restful_webservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muthu.rest.webservice.restful_webservice.users.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
