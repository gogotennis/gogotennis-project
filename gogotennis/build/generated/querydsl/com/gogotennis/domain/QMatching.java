package com.gogotennis.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMatching is a Querydsl query type for Matching
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMatching extends EntityPathBase<Matching> {

    private static final long serialVersionUID = 1479617605L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMatching matching = new QMatching("matching");

    public final StringPath author = createString("author");

    public final StringPath beforeHour = createString("beforeHour");

    public final StringPath beforeTwoHour = createString("beforeTwoHour");

    public final StringPath content = createString("content");

    public final EnumPath<com.gogotennis.web.CourtType> courtType = createEnum("courtType", com.gogotennis.web.CourtType.class);

    public final StringPath createdDate = createString("createdDate");

    public final EnumPath<com.gogotennis.web.GameResult> gameResult = createEnum("gameResult", com.gogotennis.web.GameResult.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lat = createString("lat");

    public final StringPath lng = createString("lng");

    public final EnumPath<com.gogotennis.web.MatchingCondition> matchingCondition = createEnum("matchingCondition", com.gogotennis.web.MatchingCondition.class);

    public final DatePath<java.time.LocalDate> matchingDate = createDate("matchingDate", java.time.LocalDate.class);

    public final StringPath matchingEndTime = createString("matchingEndTime");

    public final StringPath matchingStartTime = createString("matchingStartTime");

    public final EnumPath<com.gogotennis.web.MatchingStatus> matchingStatus = createEnum("matchingStatus", com.gogotennis.web.MatchingStatus.class);

    public final EnumPath<com.gogotennis.web.MatchingType> matchingType = createEnum("matchingType", com.gogotennis.web.MatchingType.class);

    public final QMember member;

    public final StringPath modifiedDate = createString("modifiedDate");

    public final StringPath place = createString("place");

    public final NumberPath<Integer> playerNumber = createNumber("playerNumber", Integer.class);

    public final StringPath title = createString("title");

    public QMatching(String variable) {
        this(Matching.class, forVariable(variable), INITS);
    }

    public QMatching(Path<? extends Matching> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMatching(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMatching(PathMetadata metadata, PathInits inits) {
        this(Matching.class, metadata, inits);
    }

    public QMatching(Class<? extends Matching> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member"), inits.get("member")) : null;
    }

}

