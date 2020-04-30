package wang.dreamland.www.service;

import wang.dreamland.www.entity.Idea;

public interface IdeaService {
    int insertId(Idea idea);
    Idea findByName(String name);
    Idea findById(int id);
}
