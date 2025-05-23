// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

import com.azure.autorest.customization.ClassCustomization;
import com.azure.autorest.customization.Customization;
import com.azure.autorest.customization.LibraryCustomization;
import com.azure.autorest.customization.PackageCustomization;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.stmt.BlockStmt;
import org.slf4j.Logger;

import java.util.Arrays;

/**
 * This class contains the customization code to customize the AutoRest generated code for App Configuration.
 */
public class AppConfigCustomization extends Customization {

    @Override
    public void customize(LibraryCustomization customization, Logger logger) {
        PackageCustomization models = customization.getPackage("com.azure.data.appconfiguration.models");

        customizeKeyValueFilter(models.getClass("ConfigurationSettingsFilter"));
        customizeKeyValueFields(models.getClass("SettingFields"));
        customizeSnapshot(models.getClass("ConfigurationSnapshot"));
    }

    private void customizeSnapshot(ClassCustomization classCustomization) {
        classCustomization.customizeAst(ast -> {
            ast.addImport("java.time.Duration");

            ast.getClassByName(classCustomization.getClassName()).ifPresent(clazz -> {
                // Transfer Long to Duration internally
                clazz.getMethodsByName("getRetentionPeriod").get(0)
                    .setType("Duration")
                    .setBody(StaticJavaParser.parseBlock("{ return this.retentionPeriod == null ? null : Duration.ofSeconds(this.retentionPeriod); }"));

                clazz.getMethodsByName("setRetentionPeriod").get(0)
                    .setParameter(0, new Parameter().setType("Duration").setName("retentionPeriod"))
                    .setBody(StaticJavaParser.parseBlock("{ this.retentionPeriod = retentionPeriod == null ? null : retentionPeriod.getSeconds(); return this; }"));
            });
        });
    }

    private void customizeKeyValueFilter(ClassCustomization classCustomization) {
        // Edit javadoc of `setLabel` method
        classCustomization.getMethod("setLabel")
            .getJavadoc()
            .setDescription("Set the label property: Filters {@link ConfigurationSetting} by their label field.");
        // Edit javadoc of `getKey` method
        classCustomization.getMethod("getKey")
            .getJavadoc()
            .setDescription("Get the key property: Filters {@link ConfigurationSetting} by their key field.");
        // Edit javadoc of `getLabel` method
        classCustomization.getMethod("getLabel")
            .getJavadoc()
            .setDescription("Get the label property: Filters {@link ConfigurationSetting} by their label field.");
    }

    private void customizeKeyValueFields(ClassCustomization classCustomization) {
        classCustomization.customizeAst(ast -> {
            // Add imports required by class changes.
            ast.addImport("java.util.Locale");

            ClassOrInterfaceDeclaration clazz = ast.getClassByName(classCustomization.getClassName()).get();

            // Modify fromString() method

            clazz.getMethodsByName("fromString").get(0)
                .setJavadocComment(StaticJavaParser.parseJavadoc(joinWithNewline(
                    "Creates or finds a {@link SettingFields} from its string representation.",
                    "@param name a name to look for.",
                    "@return the corresponding {@link SettingFields}"
                )));

            // Add class-level javadoc
            clazz.setJavadocComment(StaticJavaParser.parseJavadoc(joinWithNewline(
                "Fields in {@link ConfigurationSetting} that can be returned from GET queries.",
                "@see SettingSelector"
            )));

            // Add toStringMapper static new method to SettingFields
            clazz.addMethod("toStringMapper", Modifier.Keyword.PUBLIC, Modifier.Keyword.STATIC).setType("String")
                .addParameter("SettingFields", "field")
                .setBody(new BlockStmt(new NodeList<>(StaticJavaParser.parseStatement("return field.toString().toLowerCase(Locale.US);"))))
                .addAnnotation(Deprecated.class)
                .setJavadocComment(StaticJavaParser.parseJavadoc(joinWithNewline(
                    " * Converts the SettingFields to a string that is usable for HTTP requests and logging.",
                    " * @param field SettingFields to map.",
                    " * @return SettingFields as a lowercase string in the US locale.",
                    " * @deprecated This method is no longer needed. SettingFields is using lower case enum value for the HTTP requests."
                )));
        });
    }

    private static String joinWithNewline(String... lines) {
        return String.join("\n", lines);
    }
}
