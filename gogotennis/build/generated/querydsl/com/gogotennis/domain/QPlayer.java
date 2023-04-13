package com.gogotennis.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPlayer is a Querydsl query type for Player
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPlayer extends EntityPathBase<Player> {

    private static final long serialVersionUID = 275811625L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPlayer player = new QPlayer("player");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMatching matching;

    public final QMember member;

    public final EnumPath<com.gogotennis.web.ResultStatus> resultStatus = createEnum("resultStatus", com.gogotennis.web.ResultStatus.class);

    public final EnumPath<com.gogotennis.web.Team> team = createEnum("team", com.gogotennis.web.Team.class);

    public QPlayer(String variable) {
        this(Player.class, forVariable(variable), INITS);
    }

    public QPlayer(Path<? extends Player> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPlayer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPlayer(PathMetadata metadata, PathInits inits) {
        this(Player.class, metadata, inits);
    }

    public QPlayer(Class<? extends Player> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.matching = inits.isInitialized("matching") ? new QMatching(forProperty("matching"), inits.get("matching")) : null;
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member"), inits.get("member")) : null;
    }

}

