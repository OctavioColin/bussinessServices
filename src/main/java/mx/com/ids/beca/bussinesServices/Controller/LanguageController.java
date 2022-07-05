package mx.com.ids.beca.bussinesServices.Controller;

import mx.com.ids.beca.bussinesServices.Model.Language;
import mx.com.ids.beca.bussinesServices.Service.LanguageService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @GetMapping("/languageDetails/{id}")
    public ResponseEntity<Language> findProductById(@PathVariable int id){
        return ResponseEntity.ok().body(languageService.findById(id));
    }

    @GetMapping("/languageList")
    public ResponseEntity<?> findAll(){
        List<Language> lista = languageService.findAll();
        if (lista.isEmpty()){
            return new ResponseEntity<>("Sin datos.", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(languageService.findAll());
    }

    @DeleteMapping("languageDelete/{id}")
    public HttpStatus deleteLanguage(@PathVariable int id){
        this.languageService.delete(id);
        return HttpStatus.OK;
    }

    @PutMapping("/languageUpdate/{id}")
    public ResponseEntity<Language> update(@PathVariable int id, @RequestBody Language language){
        language.setId(id);
        return ResponseEntity.ok().body(this.languageService.update(language));
    }
}
