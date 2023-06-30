package com.example.backendbouchon.service.repository.implementation;

import com.example.backendbouchon.dao.TagRepository;
import com.example.backendbouchon.domaine.dto.TagTO;
import com.example.backendbouchon.domaine.mapper.TagMapper;
import com.example.backendbouchon.service.repository.signature.ITagService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Scope("prototype")
@Transactional
public class TagServiceImpl implements ITagService {

    private TagRepository tagRepository;
    private TagMapper tagMapper;

    public TagServiceImpl(TagRepository tagRepository,TagMapper tagMapper) {
        this.tagRepository = tagRepository;
        this.tagMapper = tagMapper;
    }

    @Override
    public void save(TagTO tagTO) {
        tagRepository.save(tagMapper.toTagBO(tagTO));
    }

    @Override
    public List<TagTO> getAllTags() {
        return tagMapper.toListTagTO(tagRepository.findAll());

    }

    /*@Override
    public TagTO getTagById(Long CategorieId) {
        return  tagMapperImpl.toTagTO(tagRepository.findById(CategorieId).orElse(null));
    }*/

    @Override
    public void deleteAllTags() {
        tagRepository.deleteAll();
    }

}
