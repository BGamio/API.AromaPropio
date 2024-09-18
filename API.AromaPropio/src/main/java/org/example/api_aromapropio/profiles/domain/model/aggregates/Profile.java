package org.example.api_aromapropio.profiles.domain.model.aggregates;

import org.example.api_aromapropio.profiles.domain.model.commands.CreateProfileCommand;
import org.example.api_aromapropio.profiles.domain.model.valueobjects.*;
import org.example.api_aromapropio.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;

@Entity
public class Profile extends AuditableAbstractAggregateRoot<Profile> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Embedded
    private PersonName name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "email_address"))})
    private EmailAddress email;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "documentId", column = @Column(name = "document_number"))})
    private DocumentNumber documentNumber;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "phone", column = @Column(name = "phone_number"))})
    private Phone phone;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "dateOdBirth", column = @Column(name = "date_of_birthday"))})
    private DateOfBirth dateOfBirth;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "url", column = @Column(name = "url_image"))})
    private UrlImage image;


    public Profile(String name, String fatherName, String motherName, String email, String documentNumber, String phone, String dateOfBirth, String image) {
        this.name = new PersonName(name, fatherName, motherName);
        this.email = new EmailAddress(email);
        this.documentNumber = new DocumentNumber(documentNumber);
        this.phone = new Phone(phone);
        this.dateOfBirth = new DateOfBirth(dateOfBirth);
        this.image = new UrlImage(image);
    }

    public Profile() { }

    public Profile(CreateProfileCommand command) {
        this.name = new PersonName(command.name(), command.fatherName(), command.motherName());
        this.email = new EmailAddress(command.email());
        this.documentNumber = new DocumentNumber(command.documentNumber());
        this.phone = new Phone(command.phoneNumber());
        this.dateOfBirth = new DateOfBirth(command.dateOfBirth());
        this.image = new UrlImage(command.image());
    }

    public void updateName(String name, String fatherName, String motherName) {
        this.name = new PersonName(name, fatherName, motherName);
    }

    public void updateEmail(String email) {
        this.email = new EmailAddress(email);
    }

    public void updateImage(String image) {
        this.image = new UrlImage(image);
    }

    public String getFirstName(){ return name.Name(); }
    public String getFatherName(){ return name.FatherName(); }

    public String getMotherName() { return name.MotherName(); }

    public String getFullName() {
        return name.getFullName();
    }

    public String getEmailAddress() {
        return email.address();
    }

    public String getUrlImage() {
        return image.url_image();
    }
}


















