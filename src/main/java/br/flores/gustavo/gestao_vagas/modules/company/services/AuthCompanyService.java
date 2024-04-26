package br.flores.gustavo.gestao_vagas.modules.company.services;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.flores.gustavo.gestao_vagas.modules.company.dto.AuthCompanyDTO;
import br.flores.gustavo.gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class AuthCompanyService {
    
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void execute(AuthCompanyDTO authCompanyDTO) {
        var company = this.companyRepository.findByUsername(authCompanyDTO.getUsername()).orElseThrow( () -> {
            throw new UsernameNotFoundException("Company not found");
        });
        // Verificar se a senha são iguais
        var passwordMatches = this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());

        if (!passwordMatches) {
            throw new AuthenticationException();
        }
            // Se não for igual -> Erro
            // Se for igual -> Gera o Token
        
    }

}
