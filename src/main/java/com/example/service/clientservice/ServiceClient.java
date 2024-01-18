package com.example.service.clientservice;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.example.enity.Client;
import com.example.model.clientmodel.ClientRequestDto;
import com.example.model.clientmodel.ClientResponseDto;

public interface ServiceClient{
    ClientResponseDto save(ClientRequestDto clientRequestDto);

   ClientResponseDto findById(Integer id);

   ClientResponseDto findByNom(String nom);

   void delete(Integer id);

   ClientResponseDto update(ClientRequestDto clientRequestDto,Integer id) throws NotFoundException;

//    List<ClientResponseDto> finAllClients();
List<Client> finAllClients();
}
