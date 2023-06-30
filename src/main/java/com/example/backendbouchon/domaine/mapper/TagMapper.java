package com.example.backendbouchon.domaine.mapper;

import com.example.backendbouchon.domaine.dto.RoleTO;
import com.example.backendbouchon.domaine.dto.TagTO;
import com.example.backendbouchon.model.Role;
import com.example.backendbouchon.model.Tag;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",implementationName = "TagMapperImpl")
public interface TagMapper {

        TagTO toTagTO(Tag tag);

        Tag toTagBO(TagTO tagTO);

        List<TagTO> toListTagTO(List<Tag> listeTag);

        List<Tag> toListTagBO(List<TagTO> listeTag);

}
