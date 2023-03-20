package com.mjc.school.implementation.commands;

import com.mjc.school.interfaces.Command;

public class ExitCommand implements Command {
    @Override
    public boolean execute() {
        System.exit(0);
        return false;
    }
}
