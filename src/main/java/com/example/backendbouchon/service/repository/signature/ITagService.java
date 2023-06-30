package com.example.backendbouchon.service.repository.signature;

import com.example.backendbouchon.domaine.dto.TagTO;

import java.util.List;

public interface ITagService {

    void save(TagTO TagTO);
    List<TagTO> getAllTags();
    //TagTO getTagById(String Tag);
    void deleteAllTags();
}
