package com.axxes.graphql.core.repository;

import com.axxes.graphql.core.model.CompetenceCenter;
import com.axxes.graphql.core.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Predicate;

import static com.axxes.graphql.core.model.CompetenceCenter.*;
import static java.util.stream.Collectors.toList;

@Repository
public class EmployeeRepository {

    private final AtomicLong employeeId = new AtomicLong();
    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee(nextId(), "Demetrius", "Waynick", "demetrius.waynick@axxes.com", Set.of(JAVA, FRONTEND, TESTING)),
            new Employee(nextId(), "Wilton", "Rehman", "wilton.rehman@axxes.com", Set.of(JAVA, FRONTEND, TESTING)),
            new Employee(nextId(), "Grisel", "Pearman", "grisel.pearman@axxes.com", Set.of(JAVA, FRONTEND)),
            new Employee(nextId(), "Lucretia", "Vossen", "lucretia.vossen@axxes.com", Set.of(JAVA, FRONTEND)),
            new Employee(nextId(), "Sallie", "Schroth", "sallie.schroth@axxes.com", Set.of(JAVA, FRONTEND)),
            new Employee(nextId(), "Tony", "Depp", "tony.depp@axxes.com", Set.of(JAVA, TESTING)),
            new Employee(nextId(), "Marietta", "Sharman", "marietta.sharman@axxes.com", Set.of(JAVA, TESTING)),
            new Employee(nextId(), "Dayna", "Salgado", "dayna.salgado@axxes.com", Set.of(JAVA, TESTING)),
            new Employee(nextId(), "Norman", "Isley", "norman.isley@axxes.com", Set.of(INFRA)),
            new Employee(nextId(), "Arnita", "Corbin", "arnita.corbin@axxes.com", Set.of(INFRA)),
            new Employee(nextId(), "Horacio", "Sons", "horacio.sons@axxes.com", Set.of(INFRA)),
            new Employee(nextId(), "Ivette", "Plemons", "ivette.plemons@axxes.com", Set.of(INFRA)),
            new Employee(nextId(), "Berneice", "Hites", "berneice.hites@axxes.com", Set.of(INFRA)),
            new Employee(nextId(), "Magdalene", "Stender", "magdalene.stender@axxes.com", Set.of(INFRA)),
            new Employee(nextId(), "Ha", "Rumfelt", "ha.rumfelt@axxes.com", Set.of(INFRA)),
            new Employee(nextId(), "Werner", "Laughter", "werner.laughter@axxes.com", Set.of(INFRA)),
            new Employee(nextId(), "Lorean", "Laplaca", "lorean.laplaca@axxes.com", Set.of(INFRA)),
            new Employee(nextId(), "Omega", "Oberholtzer", "omega.oberholtzer@axxes.com", Set.of(INFRA)),
            new Employee(nextId(), "Deedee", "Travis", "deedee.travis@axxes.com", Set.of(TESTING)),
            new Employee(nextId(), "Twana", "Patlan", "twana.patlan@axxes.com", Set.of(TESTING)),
            new Employee(nextId(), "Gayla", "Lindholm", "gayla.lindholm@axxes.com", Set.of(TESTING)),
            new Employee(nextId(), "Loma", "Reiner", "loma.reiner@axxes.com", Set.of(TESTING)),
            new Employee(nextId(), "Delsie", "Burdett", "delsie.burdett@axxes.com", Set.of(TESTING)),
            new Employee(nextId(), "Ettie", "Kessinger", "ettie.kessinger@axxes.com", Set.of(TESTING)),
            new Employee(nextId(), "Vergie", "Foulds", "vergie.foulds@axxes.com", Set.of(TESTING)),
            new Employee(nextId(), "Rico", "Busse", "rico.busse@axxes.com", Set.of(JAVA)),
            new Employee(nextId(), "Tisha", "Brett", "tisha.brett@axxes.com", Set.of(JAVA)),
            new Employee(nextId(), "Gwenda", "Lando", "gwenda.lando@axxes.com", Set.of(JAVA)),
            new Employee(nextId(), "Tamica", "Rabb", "tamica.rabb@axxes.com", Set.of(JAVA)),
            new Employee(nextId(), "Bradford", "Reels", "bradford.reels@axxes.com", Set.of(JAVA)),
            new Employee(nextId(), "Marin", "Vanover", "marin.vanover@axxes.com", Set.of(JAVA)),
            new Employee(nextId(), "Yer", "Lush", "yer.lush@axxes.com", Set.of(JAVA)),
            new Employee(nextId(), "Margit", "Luong", "margit.luong@axxes.com", Set.of(JAVA)),
            new Employee(nextId(), "Erline", "Shahan", "erline.shahan@axxes.com", Set.of(JAVA)),
            new Employee(nextId(), "Tomi", "Mcclintic", "tomi.mcclintic@axxes.com", Set.of(JAVA)),
            new Employee(nextId(), "Patti", "Ulery", "patti.ulery@axxes.com", Set.of(JAVA)),
            new Employee(nextId(), "Sherrell", "Dillion", "sherrell.dillion@axxes.com", Set.of(DOTNET, FRONTEND, TESTING)),
            new Employee(nextId(), "Tabitha", "Hulett", "tabitha.hulett@axxes.com", Set.of(DOTNET, FRONTEND, TESTING)),
            new Employee(nextId(), "Shanti", "Koepke", "shanti.koepke@axxes.com", Set.of(DOTNET, FRONTEND)),
            new Employee(nextId(), "Bertha", "Roehl", "bertha.roehl@axxes.com", Set.of(DOTNET, FRONTEND)),
            new Employee(nextId(), "Raelene", "Hurd", "raelene.hurd@axxes.com", Set.of(DOTNET, TESTING)),
            new Employee(nextId(), "Lin", "Portier", "lin.portier@axxes.com", Set.of(DOTNET, TESTING)),
            new Employee(nextId(), "Epifania", "Hartsell", "epifania.hartsell@axxes.com", Set.of(DOTNET, TESTING)),
            new Employee(nextId(), "Elsy", "Terranova", "elsy.terranova@axxes.com", Set.of(DOTNET)),
            new Employee(nextId(), "Dean", "Dungan", "dean.dungan@axxes.com", Set.of(DOTNET)),
            new Employee(nextId(), "Kelley", "Leiser", "kelley.leiser@axxes.com", Set.of(DOTNET)),
            new Employee(nextId(), "Fredric", "Troop", "fredric.troop@axxes.com", Set.of(DOTNET)),
            new Employee(nextId(), "Rocco", "Witherite", "rocco.witherite@axxes.com", Set.of(DOTNET)),
            new Employee(nextId(), "Karolyn", "Steen", "karolyn.steen@axxes.com", Set.of(DOTNET)),
            new Employee(nextId(), "Arno", "Turelinckx", "", Set.of(JAVA))
    ));

    public List<Employee> findAllEmployees(CompetenceCenter competenceCenter) {
        return employees.stream()
                .filter(EmployeeInGivenCompetenceCenter(competenceCenter))
                .collect(toList());
    }

    private long nextId() {
        return employeeId.incrementAndGet();
    }

    private Predicate<Employee> EmployeeInGivenCompetenceCenter(CompetenceCenter competenceCenter) {
        return e -> Optional.ofNullable(competenceCenter)
                .map(cc -> e.getCompetenceCenters().contains(competenceCenter))
                .orElse(true);
    }

    public Employee create(String firstName, String lastName, String email, Set<CompetenceCenter> competenceCenters) {
        var employee = new Employee(nextId(), firstName, lastName, email, competenceCenters);
        employees.add(employee);
        return employee;
    }
}
