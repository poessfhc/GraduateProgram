package wang.dreamland.www.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import wang.dreamland.www.dao.IdeaMapper;
import wang.dreamland.www.entity.Idea;
import wang.dreamland.www.service.IdeaService;

public class IdeaServiceImpl implements IdeaService {
    @Autowired
    private IdeaMapper ideaMapper;
    @Override
    public int insertId(Idea idea) {


        return ideaMapper.insert(idea);
    }

    @Override
    public Idea findByName(String name) {
        Idea idea = new Idea();
        idea.setName(name);
        return ideaMapper.selectOne(idea);
    }

    @Override
    public Idea findById(int id) {
        Idea idea = new Idea();
        idea.setId(id);
        return ideaMapper.selectOne(idea);
    }
}
