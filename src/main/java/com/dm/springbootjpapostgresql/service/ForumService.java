package com.dm.springbootjpapostgresql.service;


import java.util.List;

import com.dm.springbootjpapostgresql.dto.PostRecord;

public interface ForumService {
    PostRecord findPostRecordById(Long postId);
    PostRecord insertPostRecord(PostRecord postRecord);
    //PostRecord mergePostRecord(PostRecord postRecord);
}
