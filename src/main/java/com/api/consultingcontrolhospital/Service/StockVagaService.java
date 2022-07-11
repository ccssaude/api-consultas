package com.api.consultingcontrolhospital.Service;

import com.api.consultingcontrolhospital.Models.Consulta;
import com.api.consultingcontrolhospital.Models.Hospital;
import com.api.consultingcontrolhospital.Models.Paciente;
import com.api.consultingcontrolhospital.Repositories.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class StockVagaService {
    final ConsultaRepository consultaRepository;

    public StockVagaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }
    public List<Paciente> PacientesMarcados(String data_marcada, Integer hospital_id) throws ParseException {

        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Hospital hospital = new Hospital();
        hospital.setId(hospital_id);
        Date d = dateFormat.parse(data_marcada);
        List<Paciente> pacientesMarcados = consultaRepository.pacientesMarcados(hospital, d);
        System.out.println(data_marcada);
        return pacientesMarcados;
    }
    public Consulta VerificarDisponibilidadeConsulta() throws ParseException {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
        String quinta = dateFormat.format(calendar.getTime());
        Integer hospital_id = 2;
        List<Paciente> pacientesMarcados;
        Consulta consultaDisponivel = new Consulta();
        pacientesMarcados = PacientesMarcados(quinta, hospital_id);
        if (pacientesMarcados.size() < 10) {
            consultaDisponivel = new Consulta(quinta, hospital_id);
            return consultaDisponivel;
        } else {
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
            String sexta = dateFormat.format(calendar.getTime());
            pacientesMarcados = PacientesMarcados(sexta, hospital_id);
            if (pacientesMarcados.size() < 10) {
                consultaDisponivel = new Consulta(sexta, hospital_id);
                return consultaDisponivel;
            } else {
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                calendar.add(Calendar.DATE, 7);
                String nextThrusday = dateFormat.format(calendar.getTime());
                System.out.println(dateFormat.format(calendar.getTime()));
                pacientesMarcados = PacientesMarcados(nextThrusday, hospital_id);
                if (pacientesMarcados.size() < 10) {
                    consultaDisponivel = new Consulta(nextThrusday, hospital_id);
                    return consultaDisponivel;
                } else {
                    calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                    calendar.add(Calendar.DATE, 7);
                    String nextFriday = dateFormat.format(calendar.getTime());
                    System.out.println(dateFormat.format(calendar.getTime()));
                    pacientesMarcados = PacientesMarcados(nextFriday, hospital_id);
                    if (pacientesMarcados.size() < 10) {
                        consultaDisponivel = new Consulta(nextFriday, hospital_id);
                        return consultaDisponivel;
                    } else {
                        calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                        calendar.add(Calendar.DATE, 14);
                        String otherThrusday = dateFormat.format(calendar.getTime());
                        System.out.println(dateFormat.format(calendar.getTime()));
                        pacientesMarcados = PacientesMarcados(otherThrusday, hospital_id);
                        if (pacientesMarcados.size() < 10) {
                            consultaDisponivel = new Consulta(otherThrusday, hospital_id);
                            return consultaDisponivel;
                        }else {
                            calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                            calendar.add(Calendar.DATE, 14);
                            String otherFriday = dateFormat.format(calendar.getTime());
                            System.out.println(dateFormat.format(calendar.getTime()));
                            pacientesMarcados = PacientesMarcados(otherFriday, hospital_id);
                            if (pacientesMarcados.size() < 10) {
                                consultaDisponivel = new Consulta(otherFriday, hospital_id);
                                return consultaDisponivel;
                            }
                        }
                    }
                }
            }
        }
        return consultaDisponivel;
    }
}