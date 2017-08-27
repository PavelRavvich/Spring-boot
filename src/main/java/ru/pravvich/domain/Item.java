package ru.pravvich.domain;

import javax.persistence.*;

/**
 * Author : Pavel Ravvich.
 * Created : 18.08.17.
 */
@Entity(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "author_id")
    private int authorId;

    @ManyToOne()
    @JoinColumn(name = "author_id", referencedColumnName = "id",
            insertable = false, updatable = false
    )
    private User author;

    public Item() {
    }

    public Item(String description, User author) {
        this.description = description;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        Item item = (Item) o;

        if (id != item.id) return false;
        return description.equals(item.description);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
