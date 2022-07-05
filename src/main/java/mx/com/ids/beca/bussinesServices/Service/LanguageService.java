package mx.com.ids.beca.bussinesServices.Service;

import mx.com.ids.beca.bussinesServices.Model.Language;

import java.util.List;

public interface LanguageService {

    public Language findById(Integer id);
    public List<Language> findAll();
    public void delete(Integer id);
    public Language update(Language language);

}
