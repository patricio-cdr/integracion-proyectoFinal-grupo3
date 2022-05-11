package pe.isil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.model.Role;
import pe.isil.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements BaseService<Role, Integer>{

    @Autowired
    RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    @Override
    public void create(Role role) {
        roleRepository.save(role);
    }

    @Override
    public List<Role> read() {
        return roleRepository.findAll();
    }

    @Override
    public void update(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void delete(Role role) {
        roleRepository.delete(role);
    }

    @Override
    public Optional<Role> readById(Integer s) {
        return roleRepository.findById(s);
    }
}
