package mx.com.ids.beca.bussinesServices.Repository;

import mx.com.ids.beca.bussinesServices.Model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {

}
