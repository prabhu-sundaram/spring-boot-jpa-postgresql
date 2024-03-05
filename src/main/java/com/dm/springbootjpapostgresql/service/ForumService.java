package com.dm.springbootjpapostgresql.service;

import com.dm.springbootjpapostgresql.dto.PostRecord;

public interface ForumService {
    PostRecord findPostRecordById(Long postId);
    PostRecord insertPostRecord(PostRecord postRecord);
    //PostRecord mergePostRecord(PostRecord postRecord);
    PostRecord updatePostRecord(PostRecord postRecord);
}
