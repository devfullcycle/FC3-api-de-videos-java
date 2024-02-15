package com.fullcycle.catalogo.infrastructure.video.persistence;

import com.fullcycle.catalogo.domain.video.Video;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.time.Instant;
import java.util.Set;

@Document(indexName = "videos")
public class VideoDocument {

    @Id
    private String id;

    @MultiField(
            mainField = @Field(type = FieldType.Text, name = "title"),
            otherFields = @InnerField(suffix = "keyword", type = FieldType.Keyword)
    )
    private String title;

    @Field(type = FieldType.Text, name = "description")
    private String description;

    @Field(type = FieldType.Integer, name = "launched_at")
    private int launchedAt;

    @Field(type = FieldType.Double, name = "duration")
    private double duration;

    @Field(type = FieldType.Keyword, name = "rating")
    private String rating;

    @Field(type = FieldType.Boolean, name = "opened")
    private boolean opened;

    @Field(type = FieldType.Boolean, name = "published")
    private boolean published;

    @Field(type = FieldType.Date, name = "created_at")
    private Instant createdAt;

    @Field(type = FieldType.Date, name = "updated_at")
    private Instant updatedAt;

    @Field(type = FieldType.Keyword, name = "video")
    private String video;

    @Field(type = FieldType.Keyword, name = "trailer")
    private String trailer;

    @Field(type = FieldType.Keyword, name = "banner")
    private String banner;

    @Field(type = FieldType.Keyword, name = "thumbnail")
    private String thumbnail;

    @Field(type = FieldType.Keyword, name = "thumbnailHalf")
    private String thumbnailHalf;

    @Field(type = FieldType.Keyword, name = "categories")
    private Set<String> categories;

    @Field(type = FieldType.Keyword, name = "cast_members")
    private Set<String> castMembers;

    @Field(type = FieldType.Keyword, name = "genres")
    private Set<String> genres;

    public VideoDocument(
            final String id,
            final String title,
            final String description,
            final int launchedAt,
            final double duration,
            final String rating,
            final boolean opened,
            final boolean published,
            final Instant createdAt,
            final Instant updatedAt,
            final String video,
            final String trailer,
            final String banner,
            final String thumbnail,
            final String thumbnailHalf,
            final Set<String> categories,
            final Set<String> castMembers,
            final Set<String> genres
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.launchedAt = launchedAt;
        this.duration = duration;
        this.rating = rating;
        this.opened = opened;
        this.published = published;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.video = video;
        this.trailer = trailer;
        this.banner = banner;
        this.thumbnail = thumbnail;
        this.thumbnailHalf = thumbnailHalf;
        this.categories = categories;
        this.castMembers = castMembers;
        this.genres = genres;
    }

    public static VideoDocument from(final Video video) {
        return new VideoDocument(
                video.id(),
                video.title(),
                video.description(),
                video.launchedAt().getValue(),
                video.duration(),
                video.rating().getName(),
                video.opened(),
                video.published(),
                video.createdAt(),
                video.updatedAt(),
                video.video(),
                video.trailer(),
                video.banner(),
                video.thumbnail(),
                video.thumbnailHalf(),
                Set.copyOf(video.categories()),
                Set.copyOf(video.castMembers()),
                Set.copyOf(video.genres())
        );
    }

    public Video toVideo() {
        return Video.with(
                id,
                title,
                description,
                launchedAt,
                duration,
                rating,
                opened,
                published,
                createdAt.toString(),
                updatedAt.toString(),
                video,
                trailer,
                banner,
                thumbnail,
                thumbnailHalf,
                categories,
                castMembers,
                genres
        );
    }

    public String id() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String title() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String description() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int launchedAt() {
        return launchedAt;
    }

    public void setLaunchedAt(int launchedAt) {
        this.launchedAt = launchedAt;
    }

    public double duration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String rating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public boolean opened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    public boolean published() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public Instant createdAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant updatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String video() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String trailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String banner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String thumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String thumbnailHalf() {
        return thumbnailHalf;
    }

    public void setThumbnailHalf(String thumbnailHalf) {
        this.thumbnailHalf = thumbnailHalf;
    }

    public Set<String> categories() {
        return categories;
    }

    public void setCategoriesId(Set<String> categories) {
        this.categories = categories;
    }

    public Set<String> castMembers() {
        return castMembers;
    }

    public void setCastMembersId(Set<String> castMembers) {
        this.castMembers = castMembers;
    }

    public Set<String> genres() {
        return genres;
    }

    public void setGenresId(Set<String> genres) {
        this.genres = genres;
    }
}
