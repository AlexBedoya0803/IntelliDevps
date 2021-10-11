package com.ApiRest.APIRest;

import com.ApiRest.APIRest.models.Proyecto;
import com.ApiRest.APIRest.models.Usuario;
import com.ApiRest.APIRest.repositories.ProyectoRepository;
import com.ApiRest.APIRest.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ApiRestApplication implements CommandLineRunner {

	private final UsuarioRepository usuarioRepository;
	private final ProyectoRepository proyectoRepository;

	@Autowired
	public ApiRestApplication(UsuarioRepository usuarioRepository, ProyectoRepository proyectoRepository) {
		this.usuarioRepository = usuarioRepository;
		this.proyectoRepository = proyectoRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		if (usuarioRepository.findAll().isEmpty()){
			List<String> proyectos1 = new ArrayList<>();
			List<String> proyectos2 = new ArrayList<>();
			proyectos1.add("61612813b69dea045efa4baa");
			proyectos2.add("61612813b69dea045efa4baa");
			Usuario usuario01 = new Usuario( "Jhon",  "Jhon@gmail.com",  "Medicina",  "1234567890",  new Date(),  "Jefe", proyectos1);
			Usuario usuario02 = new Usuario( "Alex",  "Alex@gmail.com",  "Ingeniería",  "0987654321",  new Date(),  "Jefe", proyectos2);
			usuarioRepository.save(usuario01);
			usuarioRepository.save(usuario02);
		}

		for(Usuario usuario : usuarioRepository.findAll()){
			System.out.println(usuario);
		}

		if (proyectoRepository.findAll().isEmpty()){
			List<String> objetivos = new ArrayList<>();
			List<String> observaciones = new ArrayList<>();
			List<String> users = new ArrayList<>();
			users.add("6160fda3ac9862456eee92b6");
			Proyecto proyecto01 = new Proyecto("Calentamiento global", "Una descripción muy larga", new Date(), new Date(121,11,16), objetivos , observaciones, 20000000, "Activo", "En desarrollo", "Investigativo", users);
			proyectoRepository.save(proyecto01);
		}

		for(Proyecto proyecto : proyectoRepository.findAll()){
			System.out.println(proyecto);
		}
	}
}
