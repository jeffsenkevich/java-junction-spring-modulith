package com.example.javajunction.modulith;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

import java.io.File;

@SpringBootTest
public class ModuleTests {

    private ApplicationModules modules;

    @BeforeEach
    void setup() {
        modules = ApplicationModules.of(JavaJunctionModulithApplication.class);
    }

    @Test
    void printModules() {
        System.out.println(modules);
    }

    @Test
    void writeDocs() {
        new Documenter(modules).writeDocumentation();
    }

    @Test
    void writeUmlDiagrams() {
        var outputFolder = ((new File("pom.xml")).exists() ? "target" : "build")
                .concat("/").concat("spring-modulith-docs/").concat("uml");
        Documenter.DiagramOptions diagramOptions = Documenter.DiagramOptions
                .defaults()
                .withStyle(Documenter.DiagramOptions.DiagramStyle.UML);
        new Documenter(modules, outputFolder)
                .writeModulesAsPlantUml(diagramOptions)
                .writeIndividualModulesAsPlantUml(diagramOptions);
    }

    @Test
    void verifyModules() {
        modules.verify();
    }

}
