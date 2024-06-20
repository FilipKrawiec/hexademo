package com.krawart.hexademo.kernel.application.cqrs;

public interface CommandService<C extends Command, O> {
  O execute(C command);
}
