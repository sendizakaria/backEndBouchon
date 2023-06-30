package com.example.backendbouchon.domaine.mapper;

import com.example.backendbouchon.domaine.dto.UserTO;
import com.example.backendbouchon.model.User;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring",implementationName = "UserMapperImpl")
public interface UserMapper {

        UserTO toUserTO(User user);

        UserTO toUserTOFromOptional(Optional<User> user);

        User toUserBO(UserTO user);

        default List<UserTO> toListUserTO(List<User> listUser) {
          if ( listUser == null ) {
                return null;
          }

          List<UserTO> list = new ArrayList<>( listUser.size() );
         

         return list;
        }
}
