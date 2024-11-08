package com.ecoswap.ecoswap.user.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ecoswap.ecoswap.product.models.dto.ProductDTO;
import com.ecoswap.ecoswap.user.exceptions.UserNotFoundException;
import com.ecoswap.ecoswap.user.models.dto.UserDTO;
import com.ecoswap.ecoswap.user.models.entities.User;
import com.ecoswap.ecoswap.user.repositories.UserRepository;
import com.ecoswap.ecoswap.user.services.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
        .map(user -> new UserDTO(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getAddress(),
            user.getCellphoneNumber()
        ))
        .collect(Collectors.toList());

    }

    @Override
    public void createUser(UserDTO userDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createUser'");
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getEmail(), user.getCellphoneNumber());
    }

    @Override
    public ProductDTO updateUserById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUserById'");
    }

    @Override
    public void deleteUser(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

    @Override
    public UserDTO getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User usuarioAutenticado = (User) auth.getPrincipal();
        if (usuarioAutenticado == null || !auth.isAuthenticated()) {
            throw new RuntimeException("Usuario no autenticado");
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setId(usuarioAutenticado.getId());
        userDTO.setName(usuarioAutenticado.getName());
        userDTO.setEmail(usuarioAutenticado.getEmail());

        return userDTO;
    }

}
