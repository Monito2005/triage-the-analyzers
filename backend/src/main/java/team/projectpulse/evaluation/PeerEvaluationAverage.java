package team.projectpulse.evaluation;

import java.util.ArrayList;

import java.util.List;

public class PeerEvaluationAverage {

    private Integer studentId;
    private String week;
    private String firstName;
    private String lastName;
    private String email;
    private String teamName;
    private Double averageTotalScore;
    private List<String> publicComments;
    private List<String> privateComments;
    private List<RatingAverage> ratingAverages;


    public PeerEvaluationAverage() {
        // Explicit no-argument constructor for creating and populating this data object.
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Double getAverageTotalScore() {
        return averageTotalScore;
    }

    public void setAverageTotalScore(Double averageTotalScore) {
        this.averageTotalScore = averageTotalScore;
    }

    public List<String> getPublicComments() {
        // Copy present lists while preserving the existing null/unset response value.
        return java.util.Optional.ofNullable(publicComments).map(ArrayList::new).orElse(null);
    }

    public void setPublicComments(List<String> publicComments) {
        this.publicComments = publicComments == null ? null : new ArrayList<>(publicComments);
    }

    public List<String> getPrivateComments() {
        // Copy present lists while preserving the existing null/unset response value.
        return java.util.Optional.ofNullable(privateComments).map(ArrayList::new).orElse(null);
    }

    public void setPrivateComments(List<String> privateComments) {
        this.privateComments = privateComments == null ? null : new ArrayList<>(privateComments);
    }

    public List<RatingAverage> getRatingAverages() {
        // Copy present lists while preserving the existing null/unset response value.
        return java.util.Optional.ofNullable(ratingAverages).map(ArrayList::new).orElse(null);
    }

    public void setRatingAverages(List<RatingAverage> ratingAverages) {
        this.ratingAverages = ratingAverages == null ? null : new ArrayList<>(ratingAverages);
    }

}
