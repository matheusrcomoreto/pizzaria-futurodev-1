package br.com.agls.pizzariafuturodev.model.service;

import br.com.agls.pizzariafuturodev.model.entity.Mesa;
import br.com.agls.pizzariafuturodev.model.repository.MesaRepository;
import br.com.agls.pizzariafuturodev.model.service.interfaces.MesaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MesaServiceImpl implements MesaService {

    /*
    Injeção do MesaRepository utilizando o @autowired, isso substitui o new.
     */
    @Autowired
    private MesaRepository mesaRepository;

    @Override
    public Mesa salvar(Mesa mesa) {
        Mesa mesaSalvar = this.mesaRepository.save(mesa);// Momento que chama a camada de repository
        return mesaSalvar;
    }

    @Override
    public Mesa atualizar(Mesa mesa) {
       Optional<Mesa> mesaPesquisada = this.mesaRepository.findById(mesa.getId());

       if(mesaPesquisada.isPresent()) {
           mesaPesquisada.get().setStatus(mesa.getStatus());
           // BeanUtils.copyProperties(mesa,mesaPesquisada.get(),"id");
           return this.mesaRepository.save(mesaPesquisada.get());
       }
        return null;
    }

    @Override
    public Mesa buscar(Long id) {
        Optional<Mesa> mesa = this.mesaRepository.findById(id);// Momento que chama a camada de repository

        if(mesa.isPresent()) {
            return mesa.get();
        }
        return null;
    }

    @Override
    public List<Mesa> listar() {
        return this.mesaRepository.findAll();
    }// Momento que chama a camada de repository

    @Override
    public List<Mesa> listarAtivas() {
        List<Mesa> mesas = this.mesaRepository.findAll();
        List<Mesa> mesasAtivas = new ArrayList<>();

//          List<Mesa> mesas = this.mesaRepository.findAll()
//                .stream()
//                .filter(mesa -> mesa.getStatus() == true)
//                .collect(Collectors.toList());

//        mesas.forEach(mesa -> {
//            if(mesa.getStatus() == true) {
//                mesasAtivas.add(mesa);
//            }
//        });

        for(int i = 0; i < mesas.size();i++) {
            if(mesas.get(i).getStatus() == true) {
                mesasAtivas.add(mesas.get(i));
            }
        }

        return mesasAtivas;
    }

    @Override
    public void excluir(Long id) {

    }
}
