package mx.com.ids.beca.bussinesServices.Service;

import mx.com.ids.beca.bussinesServices.Model.Country;
import mx.com.ids.beca.bussinesServices.Model.Language;
import mx.com.ids.beca.bussinesServices.Repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageServiceImpl implements LanguageService{

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public Language findById(Integer id) {
        Optional<Language> languageDB = this.languageRepository.findById(id);
        if(languageDB.isPresent()){
            return languageDB.get();
        }else{
            throw new RuntimeException("Record not found with id: " + id);
        }
    }

    @Override
    public List<Language> findAll() {
        return (List<Language>) this.languageRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        Optional<Language> languageDB = this.languageRepository.findById(id);
        if(languageDB.isPresent()){
            this.languageRepository.delete(languageDB.get());
        }else{
            throw new RuntimeException("Record not found with id: " + id);
        }
    }

    @Override
    public Language update(Language language) {
        Optional<Language> languageDB = this.languageRepository.findById(language.getId());
        if(languageDB.isPresent()){
            Language languageUpdate = languageDB.get();
            languageUpdate.setId(language.getId());
            languageUpdate.setName(language.getName());
            languageUpdate.setCode(language.getCode());
            languageRepository.save(languageUpdate);
            return languageUpdate;
        }else{
            throw new RuntimeException("Record not found with id:" + language.getId());
        }
    }
}
