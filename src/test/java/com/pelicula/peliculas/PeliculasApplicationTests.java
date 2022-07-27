package com.pelicula.peliculas;

import com.pelicula.peliculas.entity.TokenUser;
import com.pelicula.peliculas.entity.Usuario;
import com.pelicula.peliculas.repository.UsuarioRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class PeliculasApplicationTests {
	@Autowired
	private UsuarioRepository repoUser;
	@Autowired
	UsuarioRepository r;

	@Test
	void contextLoads() {
		/*Usuario usuario =new Usuario() ;
		usuario.setUsuario("hola");
		//usuario.setPassword(encoder.encode("usuario"));
		boolean s=encoder.matches("","");

		repoUser.save(usuario);*/
		/*Usuario usuario=new Usuario();
		usuario.setPassword("123456789");
		usuario.setUsuario("usuarioA");
		Usuario usuarioReg;
		Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		char[] vowelArray = usuario.getPassword().toCharArray();
		String resulHas=argon2.hash(1,1024,1,vowelArray);
		try {
			usuario.setPassword(resulHas);
			usuarioReg=r.save(usuario);
		}catch (Exception e){
			System.out.println(e);
		}*/

	}
	/*@Test
	void contextLogi(){
		Usuario usuarioIn=new Usuario();
		usuarioIn.setPassword("123456789");
		usuarioIn.setUsuario("usuarioA");

		Usuario usuario1;
		TokenUser tokenUser = new TokenUser();
		try {

			usuario1=r.findByUsuario(usuarioIn.getUsuario());
			System.out.println(usuario1.getIdUsuario()+"encontrado");
			Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
			char[] passChar = usuarioIn.getPassword().toCharArray();
			boolean esTrue=argon2.verify(usuario1.getPassword(),passChar);
			if (esTrue){
				System.out.println("encontrado");
			}else {
				System.out.println("No encontrado");
			}
		}
		catch (Exception e){

		}

	}*/

}
