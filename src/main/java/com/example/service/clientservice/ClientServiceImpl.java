package com.example.service.clientservice;

import java.util.List;
import java.util.Optional;

import com.example.repository.ClientRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.enity.Client;
import com.example.exeption.EntityNotFoundExeption;
import com.example.model.clientmodel.ClientRequestDto;
import com.example.model.clientmodel.ClientResponseDto;

@Service
public class ClientServiceImpl implements ServiceClient {
    @Autowired
    private ClientRepository ClientRepository;
   private final ModelMapper modelMapper;
   public ClientServiceImpl(ClientRepository ClientRepository , ModelMapper modelMapper){
       this.ClientRepository = ClientRepository;
       this.modelMapper = modelMapper;
   }

   @Override
   public ClientResponseDto save(ClientRequestDto clientRequestDto) {
       Client client =modelMapper.map(clientRequestDto,Client.class);
       Client saved =ClientRepository.save(client);
       return modelMapper.map(saved,ClientResponseDto.class);
   }
   @Override
   public ClientResponseDto findById(Integer id) {
       Client client=ClientRepository.findById(id).orElseThrow(()->new EntityNotFoundExeption("client not found"));


       return modelMapper.map(client,ClientResponseDto.class);
   }
   @Override
   public ClientResponseDto findByNom(String nom) {
       Client client =ClientRepository.findByNom(nom);
       return modelMapper.map(client, ClientResponseDto.class);
   }
   @Override
   public void delete(Integer id) {
       //clientDao.delete(id);
       ClientResponseDto clientResponseDto=findById(id);
       Client client=modelMapper.map(clientResponseDto,Client.class );
       ClientRepository.delete(client);
   }
   @Override
   public ClientResponseDto update(ClientRequestDto clientRequestDto, Integer id) throws EntityNotFoundExeption {
       Optional<Client> cOptional=ClientRepository.findById(id);
       if(cOptional.isPresent()){
           Client client =modelMapper.map(clientRequestDto, Client.class);
           client.setId(id);
           Client updated = ClientRepository.save(client);
           return modelMapper.map(updated, ClientResponseDto.class);
       }else{
           throw new EntityNotFoundExeption("client not found ");
       }

   }

    @Override
    public List<Client> finAllClients() {
        return ClientRepository.findAll();
    }

    
}
