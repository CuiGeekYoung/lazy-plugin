package com.cgy.plugin.action.act;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.encoding.EncodingProjectManager;
import com.intellij.openapi.vfs.encoding.EncodingProjectManagerImpl;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.nio.charset.StandardCharsets;

/**
 * @author cuiguiyang
 */
public class InitProjSettings extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent actionEvent) {
//        EncodingRegistry.getInstance().set();
        System.out.println("Hello Action");
//        EncodingManagerImpl.getInstance().setDefaultCharsetName();
        Project project = actionEvent.getProject();
        if(project !=null){
            EncodingProjectManagerImpl encodingManager = (EncodingProjectManagerImpl) EncodingProjectManager.getInstance(project);
            encodingManager.setEncoding(null, StandardCharsets.UTF_8);
            encodingManager.setDefaultCharsetForPropertiesFiles(null, StandardCharsets.UTF_8);
            encodingManager.setNative2AsciiForPropertiesFiles(null, true);
            EncodingProjectManagerImpl.BOMForNewUTF8Files option = EncodingProjectManagerImpl.BOMForNewUTF8Files.NEVER;
            encodingManager.setBOMForNewUtf8Files(option);
        } else {

        }

    }
}
