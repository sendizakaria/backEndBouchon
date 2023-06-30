package com.example.backendbouchon.service.testDBService;

import com.example.backendbouchon.dao.RoleRepository;
import com.example.backendbouchon.domaine.dto.*;
import com.example.backendbouchon.domaine.mapper.TagMapper;
import com.example.backendbouchon.service.repository.signature.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class GeneraleServiceImpl implements IDBTestService {

    private IUserService iUserService;
    private IRoleService iRoleService;
    private RoleRepository roleRepository;

    private ITagService iTagService;
    private IDemandeMessageService iDemandeMessageService;
    private ICategorieService iCategorieService;
    private IStudentListService iStudentService;

    private TagMapper tagMapper;

    public GeneraleServiceImpl(IUserService iUserService, IRoleService iRoleService, RoleRepository roleRepository,
                               ITagService iTagService,IDemandeMessageService iDemandeMessageService, ICategorieService iCategorieService,
                               TagMapper tagMapper
                               ,IStudentListService iStudentService
    ) {
        this.iUserService = iUserService;
        this.iRoleService = iRoleService;
        this.roleRepository = roleRepository;
        this.iTagService = iTagService;
        this.iDemandeMessageService = iDemandeMessageService;
        this.iCategorieService = iCategorieService;
        this.tagMapper = tagMapper;
        this.iStudentService = iStudentService;

    }

    @Override
    public void cleanDataBase() {
        iUserService.deleteAllUsers();
        roleRepository.deleteAll();
        iTagService.deleteAllTags();
        iCategorieService.deleteAllCategorieService();
        iDemandeMessageService.deleteAllDemandeMessage();
        iStudentService.deleteAllStudents();
    }

    @Override
    public void alimDataBase() {
        iRoleService.save(new RoleTO("ADMIN"));
        iRoleService.save(new RoleTO("CLIENT"));

        RoleTO roleAdminTO = iRoleService.getRoleByName("ADMIN");
        RoleTO roleClientTO = iRoleService.getRoleByName("CLIENT");

        UserTO admin1 = new UserTO("OU1996", "OUMAIMA", "ELQASEMY","ELQASEMY@gmail.com" ,"123456789",
                Arrays.asList(roleAdminTO,roleClientTO));

         iUserService.saveUser(admin1);

         iTagService.save(new TagTO(1L,"1AEP-2","niveau"));
         iTagService.save(new TagTO(2L,"1AEP-2","niveau"));

         iCategorieService.save(new CategorieTO(1L,"#ddc9e0","Demande","#9c27b0"));
         iCategorieService.save(new CategorieTO(2L,"#ddc9e0","Demande","#9c27b0"));

         iStudentService.saveStudent(new StudentTO(1));

           /*  List<StudentTO> student = new ArrayList<>();
            student.add(new StudentTO(1));

           StudentListeTO studentListeTO = new StudentListeTO();
            studentListeTO.setStudent(student);

         iStudentService.saveStudentList(new StudentListTO(student));
*/

         iDemandeMessageService.saveDemandeMessage(new DemandeMessageTO(1,"WAITED","","",
                 iCategorieService.getCategorie0ById(1L),
                 new StudentTO(1),
                 "<p>testtest</p>",false,true,
                 "",tagMapper.toListTagBO(iTagService.getAllTags())));

         iDemandeMessageService.saveDemandeMessage(new DemandeMessageTO(1,"WAITED","","",
                iCategorieService.getCategorie0ById(1L),
                 new StudentTO(1),
                "<p>testtest</p>",false,true,
                "",tagMapper.toListTagBO(iTagService.getAllTags())));


    }



}
