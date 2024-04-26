package br.flores.gustavo.gestao_vagas.modules.candidate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.flores.gustavo.gestao_vagas.modules.candidate.entities.CandidateEntity;
import br.flores.gustavo.gestao_vagas.modules.candidate.repositories.CandidateRepository;

@Service
public class CreateCandidateService {
    @Autowired
    private CandidateRepository candidateRepository;
    
    public CandidateEntity execute(CandidateEntity candidateEntity){
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail()).ifPresent(candidate -> {
                throw new RuntimeException("Username or email already exists");
            });
        return this.candidateRepository.save(candidateEntity);
        
    }
}
