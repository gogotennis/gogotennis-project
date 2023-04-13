package com.gogotennis.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QResultTemp is a Querydsl query type for ResultTemp
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QResultTemp extends EntityPathBase<ResultTemp> {

    private static final long serialVersionUID = 2127149017L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QResultTemp resultTemp = new QResultTemp("resultTemp");

    public final EnumPath<com.gogotennis.web.GameResult> gameResult = createEnum("gameResult", com.gogotennis.web.GameResult.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QPlayer player;

    public QResultTemp(String variable) {
        this(ResultTemp.class, forVariable(variable), INITS);
    }

    public QResultTemp(Path<? extends ResultTemp> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QResultTemp(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QResultTemp(PathMetadata metadata, PathInits inits) {
        this(ResultTemp.class, metadata, inits);
    }

    public QResultTemp(Class<? extends ResultTemp> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.player = inits.isInitialized("player") ? new QPlayer(forProperty("player"), inits.get("player")) : null;
    }

}

