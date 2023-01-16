package com.pfriz.desafiouno.api;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pfriz.desafiouno.model.Periodo;
import com.pfriz.desafiouno.model.PeriodoIn;
import com.pfriz.desafiouno.model.PeriodoOut;
import com.pfriz.desafiouno.model.SimpleFecha;

@RestController
@RequestMapping("desafio_uno")
public class DesafioUnoController {

	ConsumeService cService;
	
	@Deprecated
	@RequestMapping(
			  value = "/fechas", 
			  method = RequestMethod.GET, 
			  produces="application/json"
			) 
	public Periodo findMissingDates() {
		// solicita las fechas desde la api de techconsult
		cService = new ConsumeService();
		Periodo periodo = cService.consumePeriodosApi();
		List<LocalDate> fechasFaltantes = new ArrayList<>();
		
		if(periodo != null && periodo.getFechas()!=null) {
			List<LocalDate> fechas = periodo.getFechas();
			
			//ordena las fechas por si vinieran en desorden
			fechas.sort(Comparator
	                .comparing(ld  -> ld.toString())
	                );
			
			System.out.print(fechas);
			
			LocalDate fechaIni;
			LocalDate fechaFin;
			for(int i = -1; i< fechas.size(); i++) {

				//se inicia en -1 para que incluya la fecha creacion
				fechaIni= i == -1 ? periodo.getFechaCreacion() : fechas.get(i);
				// si la fecha siguiente no esta dentro de la lista, 
				// entonces usara la fecha de fini de periodo
				fechaFin = i + 1 < fechas.size()? fechas.get(i + 1) : periodo.getFechaFin();  
				
				//si la fecha mas un mes, no es la siguiente, buscar rangos
				if(!fechaIni.plusMonths(1).equals(fechaFin) && fechasFaltantes.size()<100) {
					fechasFaltantes.addAll(
							findFechasFaltantesPorRango(
									fechaIni, 
									fechaFin
									)
							);
				}
				if(fechasFaltantes.size()>100) {
					i = fechas.size();
				}
			}
			
		}
		
		periodo.setFechasFaltantes(
				fechasFaltantes.stream().limit(100)
				.collect(Collectors.toList()));
		
		
		return periodo;
	}
	
	private List<LocalDate> findFechasFaltantesPorRango(LocalDate ldIni, LocalDate ldFin){
		LocalDate fechaPuntero = ldIni;
		List<LocalDate> fechasFaltantes = new ArrayList<>();
		
		do {
			// aniadimos un mes y preguntamos si es igual a fechas.get(0)
			fechaPuntero=fechaPuntero.plusMonths(1);
			if(!fechaPuntero.equals(ldFin)){
				fechasFaltantes.add(fechaPuntero);
				
			}
		}while(!fechaPuntero.equals(ldFin));
		
		return fechasFaltantes;
	}


	@RequestMapping(
			  value = "/fechasFaltantes", 
			  method = RequestMethod.GET, 
			  produces="application/json"
			) 
	public PeriodoOut findMissingDatesIn() {
		List<String> fList = new ArrayList<>();
		// solicita las fechas desde la api de techconsult
		cService = new ConsumeService();
		PeriodoIn periodo = cService.consumePeriodosApiIn();

		PeriodoOut periodoOut = new PeriodoOut();
		periodoOut.setPeriodo(periodo);
		
		if(periodo != null && periodo.getFechas() != null) {
			List<String> fechas = periodo.getFechas();
			
			//aniadimos fechas para que no sean consideradas al momento de generar las faltantes
			fechas.add(periodo.getFechaCreacion());
			fechas.add(periodo.getFechaFin()
					);
			//ordena las fechas por si vinieran en desorden
			fechas.sort(Comparator
	                .comparing(ld  -> ld)
	                );
			
			System.out.print(fechas);

			SimpleFecha fIni = new SimpleFecha(periodo.getFechaCreacion());
			SimpleFecha fFin = new SimpleFecha(periodo.getFechaFin());
			
			do {
				//si la fecha a evaluar no se encuentra en los "excluidos"
				if(!fechas.contains(fIni.toString())) {
					fList.add(fIni.toString());
				}
				//sumar mes
				fIni.addMonth();
				
				//repetir mientras la fecha de inicio no sea igual a la fecha fin
			}while(!fIni.toString().equals(fFin.toString()));
			

			periodoOut.setFechasFaltantes(fList);
		
		}
		
		return periodoOut;
	}
}
