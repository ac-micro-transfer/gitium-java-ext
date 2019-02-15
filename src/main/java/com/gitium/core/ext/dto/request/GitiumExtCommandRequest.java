package com.gitium.core.ext.dto.request;

import com.gitium.core.ext.GitiumApiExtCommands;

public class GitiumExtCommandRequest {
    final String command;

    public GitiumExtCommandRequest(GitiumApiExtCommands command) {
        this.command = command.command();
    }
}