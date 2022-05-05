/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Clutchers.GUI;

import edu.Clutchers.entities.Categories;
import edu.Clutchers.entities.Produit;
import edu.Clutchers.entities.Reclamation;
import edu.Clutchers.services.CategoriesCrud;
import edu.Clutchers.services.ProduitCRUD;
import edu.Clutchers.services.ReclamationCRUD;
import java.io.File;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.PasswordAuthentication;
import java.net.URL;
import static java.time.temporal.TemporalQueries.zone;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;


/**
 * FXML Controller class
 *
 * @author sinda
 */
public class GestionProduitController implements Initializable {

    @FXML
    private TableColumn<Produit, String> tcNomprod;
    @FXML
    private TableColumn<Produit, String> tcImageprod;
    @FXML
    private TableColumn<Produit, Double> tcPrixprod;
    @FXML
    private TableColumn<Produit, String> tcDescprod;
    @FXML
    private TableColumn<Produit, Integer> tcQteprod;
    @FXML
    private TextField tfNomp;
    private TextField tfImagep;
    @FXML
    private TextField tfPrixp;
    @FXML
    private TextArea tfDescp;
    @FXML
    private TextField tfQtep;
    private TextField tfCatidprod;
    @FXML
    private Button btnInsertprod;
    @FXML
    private Button btnUpdateprod;
    @FXML
    private Button btnDelteprod;
    @FXML
    private TableView<Categories> tvCat;
    @FXML
    private TableColumn<Categories, String> tcNomCat;
    @FXML
    private TextField tfNomcat;
    @FXML
    private Button btnInsertcat;
    @FXML
    private Button btnUpdateCat;
    @FXML
    private Button btnDeletecat;
    @FXML
    private TableView<Reclamation> tableview;
    @FXML
    private TableColumn<Reclamation, String> tcSujet;
    @FXML
    private TableColumn<Reclamation, String> tcContent;
    @FXML
    private TableColumn<Reclamation, String> tcNom;
    @FXML
    private TableColumn<Reclamation, String> tcEmail;
    @FXML
    private TableColumn<Reclamation, String> tcStatus;
    @FXML
    private TextField tfSujet;
    @FXML
    private TextArea tfContent;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfStatut;
    @FXML
    private Button btnDeleterec;
    @FXML
    private Button btnUpdaterec;
    @FXML
    private TableView<Produit> tvProduit;
    @FXML
    private Button btnRetour;
    @FXML
    private ComboBox<String> CBCat;

    List<String> combox = new ArrayList<>();
    @FXML
    private Button btnRetour1;
    @FXML
    private Button btnRetour2;
    @FXML
    private TextField id_cat;
    @FXML
    private TableColumn<Produit, Integer> cat_Id;
    @FXML
    private TableColumn<String, String> tcNomcat;
    @FXML
    private RadioButton btnTRI_NOM;
    @FXML
    private RadioButton btnTRI_Quantite;
    @FXML
    private RadioButton btnTRI_prix;
    @FXML
    private Button btnRefrech;
    @FXML
    private TextField RECHERCHE;
    @FXML
    private ComboBox<String> CBCat1;
    @FXML
    private TextField id_cat1;
    @FXML
    private Button img1;
    final FileChooser fc = new FileChooser();
    //File selectedFile=new File("");
    @FXML
    private ImageView imageview;
    @FXML
    private Label cheminimage;
    @FXML
    private Button btnRefrech1;
    @FXML
    private RadioButton btnTRI_NOMcat;
    @FXML
    private TextField RECHERCHE1;
    @FXML
    private Button btnRefrech11;
    @FXML
    private RadioButton btnTRI_prix1;
    @FXML
    private RadioButton btnTRI_prix11;
    @FXML
    private ComboBox<String> sujetreclamation;
    @FXML
    private ComboBox<String> Statutfilter;
    @FXML
    private TextField rech;
    @FXML
    private RadioButton triNomrecbtn;
    @FXML
    private Button btnRependre;
    @FXML
    private Button btnStat;

    public void combox_I() {
        CategoriesCrud iss = new CategoriesCrud();
        combox = iss.combox_cat();

    }

    List<String> bolllist = new ArrayList<>();

    public void generateboll() {
        bolllist.add("Tous");
        bolllist.add("True");
        bolllist.add("False");

    }

    List<String> de1Ju5 = new ArrayList<>();

    public void generateNumbers() {
        de1Ju5.add("Tous");
        de1Ju5.add("Le catalogue produit en tête de liste");
        de1Ju5.add("L’opacité des prix");
        de1Ju5.add("Le fonctionnement du site");
        de1Ju5.add("La disponiblite du stock");
        de1Ju5.add("Les retours et rembourssements");
        de1Ju5.add("la livraison");
        de1Ju5.add("Le service apres vente");
        de1Ju5.add("Autres");

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        generateboll();
        Statutfilter.setItems(FXCollections.observableArrayList(bolllist));;
        generateNumbers();
        sujetreclamation.setItems(FXCollections.observableArrayList(de1Ju5));

        combox_I();
        CBCat.setItems(FXCollections.observableArrayList(combox));
        CBCat1.setItems(FXCollections.observableArrayList(combox));

        //affichage categories
        CategoriesCrud cc = new CategoriesCrud();
        List categories = cc.afficherCategories();
        ObservableList list = FXCollections.observableArrayList(categories);
        tvCat.setItems(list);
        tcNomCat.setCellValueFactory(new PropertyValueFactory<>("nom_c"));

        //affichage reclamation
        ReclamationCRUD rc = new ReclamationCRUD();
        List reclamations = rc.afficherRec();
        ObservableList list2 = FXCollections.observableArrayList(reclamations);
        tableview.setItems(list2);
        tcSujet.setCellValueFactory(new PropertyValueFactory<>("sujet"));
        tcContent.setCellValueFactory(new PropertyValueFactory<>("content"));
        tcNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tcStatus.setCellValueFactory(new PropertyValueFactory<>("statut"));

        // affichage produit
        ProduitCRUD pc = new ProduitCRUD();
        List produits = pc.afficherProd();
        ObservableList list3 = FXCollections.observableArrayList(produits);
        tvProduit.setItems(list3);
        // tcIdprod.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcNomprod.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tcImageprod.setCellValueFactory(new PropertyValueFactory<>("image"));
        tcPrixprod.setCellValueFactory(new PropertyValueFactory<>("prix"));
        tcDescprod.setCellValueFactory(new PropertyValueFactory<>("description"));
        tcQteprod.setCellValueFactory(new PropertyValueFactory<>("qte"));
        cat_Id.setCellValueFactory(new PropertyValueFactory<>("cat_id"));

        //tcImageprod.setPrefWidth(60);
        // tcImageprod.setCellValueFactory(new PropertyValueFactory<>("image"));
        // imageview.setImage(new Image());
        //tcNomcat.setCellValueFactory(new PropertyValueFactory<>("sorry, I have no idea what to write here in your case"));
        //tvProduit[6].setCellValueFactory("sorry, I have no idea what to write here in your case");
        //tcNomcat.setCellValueFactory(new PropertyValueFactory<>("c.nom_c"));
        //cat_Id.setCellFactory(new PropertyValueFactory<>("c.nom_c"));
        //tcCatidprod.setCellFactory(new PropertyValueFactory<>("cat_id"));
    }

    @FXML
    private void ajouterProd(ActionEvent event) {
        if (tfPrixp.getText().isEmpty()) {
            tfPrixp.requestFocus();
            //Animations.shake(txtNom);
            Alert missingFields = new Alert(Alert.AlertType.INFORMATION);
            missingFields.setHeaderText(null);
            missingFields.setContentText("veuillez remplir tout les champs");
            missingFields.initModality(Modality.APPLICATION_MODAL);
            missingFields.showAndWait();
            return;
        }
        if (tfNomp.getText().isEmpty()) {
            tfNomp.requestFocus();
            //Animations.shake(txtNom);
            Alert missingFields = new Alert(Alert.AlertType.INFORMATION);
            missingFields.setHeaderText(null);
            missingFields.setContentText("veuillez remplir tout les champs");
            missingFields.initModality(Modality.APPLICATION_MODAL);
            missingFields.showAndWait();
            return;
        }

        if (tfDescp.getText().isEmpty()) {
            tfDescp.requestFocus();
            //Animations.shake(txtNom);
            Alert missingFields = new Alert(Alert.AlertType.INFORMATION);
            missingFields.setHeaderText(null);
            missingFields.setContentText("veuillez remplir tout les champs");
            missingFields.initModality(Modality.APPLICATION_MODAL);
            missingFields.showAndWait();
            return;
        }

        if (!tfPrixp.getText().matches("^[0-9.]+$")) {
            tfPrixp.requestFocus();
            Alert missingFields = new Alert(Alert.AlertType.INFORMATION);
            missingFields.setHeaderText(null);
            missingFields.setContentText("Attention prix");
            missingFields.initModality(Modality.APPLICATION_MODAL);
            missingFields.showAndWait();
            return;
        }

        if (!tfQtep.getText().matches("^[0-9]+$")) {
            tfQtep.requestFocus();
            //Animations.shake(txtNom);
            Alert missingFields = new Alert(Alert.AlertType.INFORMATION);
            missingFields.setHeaderText(null);
            missingFields.setContentText("Attention quantire");
            missingFields.initModality(Modality.APPLICATION_MODAL);
            missingFields.showAndWait();
            return;
        }

        if (tfQtep.getText().isEmpty()) {
            tfQtep.requestFocus();
            //Animations.shake(txtNom);
            Alert missingFields = new Alert(Alert.AlertType.INFORMATION);
            missingFields.setHeaderText(null);
            missingFields.setContentText("veuillez remplir tout les champs");
            missingFields.initModality(Modality.APPLICATION_MODAL);
            missingFields.showAndWait();
            return;
        }

        if (id_cat.getText().isEmpty()) {
            tfQtep.requestFocus();
            //Animations.shake(txtNom);
            Alert missingFields = new Alert(Alert.AlertType.INFORMATION);
            missingFields.setHeaderText(null);
            missingFields.setContentText("veuillez remplir tout les champs");
            missingFields.initModality(Modality.APPLICATION_MODAL);
            missingFields.showAndWait();
            return;
        }

        if (cheminimage.getText().isEmpty()) {
            tfQtep.requestFocus();
            //Animations.shake(txtNom);
            Alert missingFields = new Alert(Alert.AlertType.INFORMATION);
            missingFields.setHeaderText(null);
            missingFields.setContentText("veuillez remplir image");
            missingFields.initModality(Modality.APPLICATION_MODAL);
            missingFields.showAndWait();
            return;
        }

        Produit p = new Produit(Double.parseDouble(tfPrixp.getText()), tfNomp.getText(), cheminimage.getText(), tfDescp.getText(), Integer.parseInt(tfQtep.getText()), Integer.parseInt(id_cat.getText()));
        ProduitCRUD pc = new ProduitCRUD();
        pc.ajouterProd(p);
        System.out.println(" essai 2");
        List produits = pc.afficherProd();
        ObservableList list = FXCollections.observableArrayList(produits);
        tvProduit.setItems(list);
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, " Produit ajouté ", ButtonType.OK);
        a.show();
        init();
    }
    /*
    public void sendEmail() {
        String to = "mednabil.kallel@esprit.tn";
        String from = "hamatalbi9921@gmail.com";
        String host = "smtp.gmail.com";
        final String username = "hamatalbi9921@gmail.com";
        final String password = "123456789hama";

        //setup mail server
        Properties props = System.getProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        Session session;
        session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            //create mail
            MimeMessage m = new MimeMessage(session);
            m.setFrom(new InternetAddress(from));
            m.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
            m.setSubject("TheAces");
            m.setText("Une Livraison a été ajouté:\n methode de paiment : " );

            Transport.send(m);

            System.out.println("Message sent!");

        } catch (MessagingException e) {
            e.printStackTrace();
//        } catch (SQLException ex) {
//            Logger.getLogger(RestPasswordController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
*/
    @FXML
    private void modifierProd(ActionEvent event) {
        if (tfNomp.getText().isEmpty()) {
            tfNomp.requestFocus();
            //Animations.shake(txtNom);
            Alert missingFields = new Alert(Alert.AlertType.INFORMATION);
            missingFields.setHeaderText(null);
            missingFields.setContentText("veuillez remplir tout les champs");
            missingFields.initModality(Modality.APPLICATION_MODAL);
            missingFields.showAndWait();
            return;
        }

        if (tfPrixp.getText().isEmpty()) {
            tfPrixp.requestFocus();
            //Animations.shake(txtNom);
            Alert missingFields = new Alert(Alert.AlertType.INFORMATION);
            missingFields.setHeaderText(null);
            missingFields.setContentText("veuillez remplir tout les champs");
            missingFields.initModality(Modality.APPLICATION_MODAL);
            missingFields.showAndWait();
            return;
        }

        if (tfDescp.getText().isEmpty()) {
            tfDescp.requestFocus();
            Alert missingFields = new Alert(Alert.AlertType.INFORMATION);
            missingFields.setHeaderText(null);
            missingFields.setContentText("veuillez remplir tout les champs");
            missingFields.initModality(Modality.APPLICATION_MODAL);
            missingFields.showAndWait();
            //Animations.shake(txtNom);
            return;
        }
        if (tfQtep.getText().isEmpty()) {
            tfQtep.requestFocus();
            Alert missingFields = new Alert(Alert.AlertType.INFORMATION);
            missingFields.setHeaderText(null);
            missingFields.setContentText("veuillez remplir tout les champs");
            missingFields.initModality(Modality.APPLICATION_MODAL);
            missingFields.showAndWait();
            //Animations.shake(txtNom);
            return;
        }

        if (id_cat.getText().isEmpty()) {
            CBCat.requestFocus();
            Alert missingFields = new Alert(Alert.AlertType.INFORMATION);
            missingFields.setHeaderText(null);
            missingFields.setContentText("veuillez remplir tout les champs");
            missingFields.initModality(Modality.APPLICATION_MODAL);
            missingFields.showAndWait();
            //Animations.shake(txtNom);
            return;
        }

        if (!tfPrixp.getText().matches("^[0-9.]+$")) {
            tfPrixp.requestFocus();
            Alert missingFields = new Alert(Alert.AlertType.INFORMATION);
            missingFields.setHeaderText(null);
            missingFields.setContentText("Attention prix");
            missingFields.initModality(Modality.APPLICATION_MODAL);
            missingFields.showAndWait();
            return;
        }

        if (!tfQtep.getText().matches("^[0-9]+$")) {
            tfQtep.requestFocus();
            //Animations.shake(txtNom);
            Alert missingFields = new Alert(Alert.AlertType.INFORMATION);
            missingFields.setHeaderText(null);
            missingFields.setContentText("Attention quantire");
            missingFields.initModality(Modality.APPLICATION_MODAL);
            missingFields.showAndWait();
            return;
        }

        Produit av = tvProduit.getSelectionModel().getSelectedItem();
        Produit c = new Produit();
        c.setId(av.getId());
        c.setNom(tfNomp.getText());
        c.setImage(cheminimage.getText());

        String m = tfPrixp.getText();
        Double str1 = Double.valueOf(m);

        c.setPrix(str1);
        c.setDescription(tfDescp.getText());
        c.setCat_id(Integer.parseInt(id_cat.getText()));
        String q = tfQtep.getText();
        int str2 = Integer.parseInt(q);

        c.setQte(str2);

        //c.setNom_c(m);
        ProduitCRUD as = new ProduitCRUD();
        Alert alert = new Alert(AlertType.CONFIRMATION, "Voulez vous modifier le produit  " + c.getNom() + " ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            as.modifierProd(c);

            List produits = as.afficherProd();
            ObservableList list = FXCollections.observableArrayList(produits);
            tvProduit.setItems(list);
            Alert a = new Alert(Alert.AlertType.CONFIRMATION, " LE Produit " + c.getNom() + " a été modifié\"", ButtonType.OK);
            a.show();
            init();
        }

    }

    @FXML
    private void SupprimerProd(ActionEvent event) {
        Produit p = tvProduit.getSelectionModel().getSelectedItem();
        ProduitCRUD pc = new ProduitCRUD();

        Alert alert = new Alert(AlertType.CONFIRMATION, "Voulez vous supprimer le produit  " + p.getNom() + " ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            pc.supprimerProd(p.getId());
            List produits = pc.afficherProd();
            ObservableList list = FXCollections.observableArrayList(produits);
            tvProduit.setItems(list);

            Alert a = new Alert(Alert.AlertType.CONFIRMATION, " LE Produit " + p.getNom() + " a été supprimé\"", ButtonType.OK);
            a.show();

            tvProduit.refresh();
        }
        init();

    }

    @FXML
    private void ajouterCat(ActionEvent event) {
        if (tfNomcat.getText().isEmpty()) {
            tfNomcat.requestFocus();
            //Animations.shake(txtNom);
            Alert missingFields = new Alert(Alert.AlertType.INFORMATION);
            missingFields.setHeaderText(null);
            missingFields.setContentText("veuillez remplir ce champs");
            missingFields.initModality(Modality.APPLICATION_MODAL);
            missingFields.showAndWait();
            return;
        }

        Categories c = new Categories(tfNomcat.getText());
        CategoriesCrud cc = new CategoriesCrud();
        cc.ajouterCategories(c);
        List categories = cc.afficherCategories();
        ObservableList list = FXCollections.observableArrayList(categories);
        tvCat.setItems(list);
        tvCat.refresh();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, " categoeie ajoutée ", ButtonType.OK);
        tvCat.refresh();
        a.show();
        init();

    }

    @FXML
    private void modifierCat(ActionEvent event) {

        if (tfNomcat.getText().isEmpty()) {
            tfNomcat.requestFocus();
            //Animations.shake(txtNom);
            Alert missingFields = new Alert(Alert.AlertType.INFORMATION);
            missingFields.setHeaderText(null);
            missingFields.setContentText("veuillez remplir ce champs");
            missingFields.initModality(Modality.APPLICATION_MODAL);
            missingFields.showAndWait();
            return;
        }
        Categories av = tvCat.getSelectionModel().getSelectedItem();
        int n = av.getId();
        String m = tfNomcat.getText();

        Categories c = new Categories();
        c.setId(n);
        c.setNom_c(m);
        CategoriesCrud as = new CategoriesCrud();
        Alert alert = new Alert(AlertType.CONFIRMATION, "Voulez vous modifier la categorie  " + c.getNom_c() + " ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            as.modifier(c);

            List categories = as.afficherCategories();
            ObservableList list = FXCollections.observableArrayList(categories);
            tvCat.setItems(list);
            Alert a = new Alert(Alert.AlertType.CONFIRMATION, "la categoeie est bien modifiée ", ButtonType.OK);
            tvCat.refresh();
            init();
        }
    }

    @FXML
    private void supprimerCat(ActionEvent event) {
        Categories c = tvCat.getSelectionModel().getSelectedItem();
        CategoriesCrud cc = new CategoriesCrud();
        Alert alert = new Alert(AlertType.CONFIRMATION, "Voulez vous supprimer la categorie  " + c.getNom_c() + " ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            cc.supprimer(c.getId());
            List categories = cc.afficherCategories();
            ObservableList list = FXCollections.observableArrayList(categories);
            tvCat.setItems(list);

            tvCat.refresh();

            CategoriesCrud iss = new CategoriesCrud();
            combox = iss.combox_cat();
            CBCat.setItems(FXCollections.observableArrayList(combox));
            CBCat1.setItems(FXCollections.observableArrayList(combox));

            ProduitCRUD as = new ProduitCRUD();
            List produits = as.afficherProd();
            ObservableList list2 = FXCollections.observableArrayList(produits);
            tvProduit.setItems(list2);
        }
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "la categoeie est bien supprimée ", ButtonType.OK);
        a.show();
        tvCat.refresh();
        init();
    }

    @FXML
    private void modifierReclamation(ActionEvent event) {

        Reclamation av = tableview.getSelectionModel().getSelectedItem();
        int n = av.getId();
        Boolean m = av.getStatut();

        Reclamation c = new Reclamation();

        ReclamationCRUD as = new ReclamationCRUD();
        Alert alert = new Alert(AlertType.CONFIRMATION, "Voulez vous modifier la réclamation de  " + c.getNom() + " ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            c.setId(n);
            c.setStatut(m);
            c.setStatut(true);
            as.modifier(c);
            List reclamations = as.afficherRec();
            ObservableList list = FXCollections.observableArrayList(reclamations);
            tableview.setItems(list);

            tableview.refresh();
        }
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "la reclamation de " + c.getNom() + " a été modifiée ", ButtonType.OK);
        a.show();

        init();

    }

    @FXML
    private void supprimerReclamation(ActionEvent event) {
        Reclamation p = tableview.getSelectionModel().getSelectedItem();
        ReclamationCRUD pc = new ReclamationCRUD();
        Alert alert = new Alert(AlertType.CONFIRMATION, "Voulez vous supprimer la reclamation de  " + p.getNom() + " ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            pc.supprimer(p.getId());
            List reclamations = pc.afficherRec();
            ObservableList list = FXCollections.observableArrayList(reclamations);
            tableview.setItems(list);

            tableview.refresh();
        }
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "la reclamation de " + p.getNom() + " a été supprimée ", ButtonType.OK);
        a.show();
        init();

    }

    private void init() {

        // tfIdcat.setText("");
        tfSujet.setText("");
        tfContent.setText("");
        tfNom.setText("");
        tfEmail.setText("");
        tfStatut.setText("");
        tfNomcat.setText("");
        //tfIdcat.setText("");
        // tfIdp.setText("");
        tfNomp.setText("");
        cheminimage.setText("");
        tfPrixp.setText("");
        tfDescp.setText("");
        tfQtep.setText("");
        CBCat.setValue("");
        // tfIdcat.setText("");
        tfCatidprod.setText("");

    }

    @FXML
    private void Retour(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FirstPage.fxml"));
        Parent root = loader.load();
        FirstPageController ap = loader.getController();
        btnRetour.getScene().setRoot(root);
    }

    private void afficher(ActionEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void affInInputsRec(MouseEvent event) {
        Reclamation av = tableview.getSelectionModel().getSelectedItem();

        int n = av.getId();
        String m = Integer.toString(n);
        //tfIdcat.setText(m);
        tfSujet.setText(av.getSujet());
        tfContent.setText(av.getContent());
        tfNom.setText(av.getNom());
        tfEmail.setText(av.getEmail());
        Boolean s = av.getStatut();
        String ss = Boolean.toString(s);
        tfStatut.setText(ss);

    }

    @FXML
    public void affInInputs(MouseEvent event) {
        Categories av = tvCat.getSelectionModel().getSelectedItem();

        tfNomcat.setText(av.getNom_c());

    }

    @FXML
    private void affInInputsProd(MouseEvent event) {
        Produit pp = tvProduit.getSelectionModel().getSelectedItem();
        int n = pp.getId();
        String m = Integer.toString(n);
        // tfIdp.setText(m);
        tfNomp.setText(pp.getNom());
        cheminimage.setText(pp.getImage());
        Double p = pp.getPrix();
        String r = Double.toString(p);
        tfPrixp.setText(r);
        tfDescp.setText(pp.getDescription());
        int q = pp.getQte();
        String qt = Integer.toString(q);
        tfQtep.setText(qt);
        int i = pp.getCat_id();
        String id = Integer.toString(i);
        id_cat.setText(id);

        CategoriesCrud c = new CategoriesCrud();

        int resultat = Integer.parseInt(id_cat.getText());

        String x = c.appel_nom_cat(resultat);
        System.out.println(m);

        CBCat.setValue(x);

        //tcImageprod.setPrefWidth(60);
        tcImageprod.setCellValueFactory(new PropertyValueFactory<>("image"));

        imageview.setImage(new Image(tcImageprod.getText()));

        // imageview.setImage(new Image(cheminimage.getText()));
        // String url=Statics.URL_REP_IMAGES + cheminimage.getText();
    }

    @FXML
    private void appel_id(ActionEvent event) {
        int m;
        CategoriesCrud c = new CategoriesCrud();
        m = c.appel_id_cat(CBCat.getValue());
        System.out.println(m);
        String id_catstring = Integer.toString(m);
        id_cat.setText(id_catstring);

    }

    @FXML
    private void triNom(ActionEvent event) {
        ProduitCRUD pc = new ProduitCRUD();
        if (btnTRI_NOM.isSelected()) {

            List produits = pc.afficherProd2();
            ObservableList list3 = FXCollections.observableArrayList(produits);
            tvProduit.setItems(list3);
        } else {
            List produits = pc.afficherProd();
            ObservableList list3 = FXCollections.observableArrayList(produits);
            tvProduit.setItems(list3);
        }
        // tcIdprod.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcNomprod.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tcImageprod.setCellValueFactory(new PropertyValueFactory<>("image"));
        tcPrixprod.setCellValueFactory(new PropertyValueFactory<>("prix"));
        tcDescprod.setCellValueFactory(new PropertyValueFactory<>("description"));
        tcQteprod.setCellValueFactory(new PropertyValueFactory<>("qte"));
        cat_Id.setCellValueFactory(new PropertyValueFactory<>("cat_id"));
        //tcNomcat.setCellValueFactory(new PropertyValueFactory<>("sorry, I have no idea what to write here in your case"));
        //tvProduit[6].setCellValueFactory("sorry, I have no idea what to write here in your case");

        //tcNomcat.setCellValueFactory(new PropertyValueFactory<>("c.nom_c"));
        //cat_Id.setCellFactory(new PropertyValueFactory<>("c.nom_c"));
        //tcCatidprod.setCellFactory(new PropertyValueFactory<>("cat_id"));}
    }

    @FXML
    private void triQuantite(ActionEvent event) {
        ProduitCRUD pc = new ProduitCRUD();
        if (btnTRI_Quantite.isSelected()) {

            List produits = pc.afficherProd3();
            ObservableList list3 = FXCollections.observableArrayList(produits);
            tvProduit.setItems(list3);
        } else {
            List produits = pc.afficherProd();
            ObservableList list3 = FXCollections.observableArrayList(produits);
            tvProduit.setItems(list3);
        }
        // tcIdprod.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcNomprod.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tcImageprod.setCellValueFactory(new PropertyValueFactory<>("image"));
        tcPrixprod.setCellValueFactory(new PropertyValueFactory<>("prix"));
        tcDescprod.setCellValueFactory(new PropertyValueFactory<>("description"));
        tcQteprod.setCellValueFactory(new PropertyValueFactory<>("qte"));
        cat_Id.setCellValueFactory(new PropertyValueFactory<>("cat_id"));
    }

    @FXML
    private void triprix(ActionEvent event) {
        ProduitCRUD pc = new ProduitCRUD();
        if (btnTRI_prix.isSelected()) {

            List produits = pc.afficherProd4();
            ObservableList list3 = FXCollections.observableArrayList(produits);
            tvProduit.setItems(list3);
        } else {
            List produits = pc.afficherProd();
            ObservableList list3 = FXCollections.observableArrayList(produits);
            tvProduit.setItems(list3);
        }
        // tcIdprod.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcNomprod.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tcImageprod.setCellValueFactory(new PropertyValueFactory<>("image"));
        tcPrixprod.setCellValueFactory(new PropertyValueFactory<>("prix"));
        tcDescprod.setCellValueFactory(new PropertyValueFactory<>("description"));
        tcQteprod.setCellValueFactory(new PropertyValueFactory<>("qte"));
        cat_Id.setCellValueFactory(new PropertyValueFactory<>("cat_id"));
    }

    
    @FXML
    private void recherche(InputMethodEvent event) {

    }

    @FXML
    private void recherche(KeyEvent event) {
        ProduitCRUD pc = new ProduitCRUD();
        if (!"".equals(RECHERCHE.getText())) {
            List produits = pc.rechercheproduit(RECHERCHE.getText());

            ObservableList list3 = FXCollections.observableArrayList(produits);
            tvProduit.setItems(list3);
        } else {
            List produits = pc.afficherProd4();
            ObservableList list3 = FXCollections.observableArrayList(produits);
            tvProduit.setItems(list3);
        }
        tcNomprod.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tcImageprod.setCellValueFactory(new PropertyValueFactory<>("image"));
        tcPrixprod.setCellValueFactory(new PropertyValueFactory<>("prix"));
        tcDescprod.setCellValueFactory(new PropertyValueFactory<>("description"));
        tcQteprod.setCellValueFactory(new PropertyValueFactory<>("qte"));
        cat_Id.setCellValueFactory(new PropertyValueFactory<>("cat_id"));
        // tcIdprod.setCellValueFactory(new PropertyValueFactory<>("id"));

    }

    @FXML
    private void Refrech(ActionEvent event) {
        // tfIdcat.setText("");
        tfSujet.setText("");
        tfContent.setText("");
        tfNom.setText("");
        tfEmail.setText("");
        tfStatut.setText("");
        tfNomcat.setText("");

        //tfIdcat.setText("");
        // tfIdp.setText("");
        tfNomp.setText("");
        //tfImagep.setText("");
        tfPrixp.setText("");
        tfDescp.setText("");
        tfQtep.setText("");
        CBCat.setValue("");
    

        //tfCatidprod.setText("");
        id_cat.setText("");
        id_cat1.setText("");
        //CBCat.setValue("");
        RECHERCHE.setText("");
        btnTRI_Quantite.setSelected(false);
        btnTRI_prix.setSelected(false);
        btnTRI_NOM.setSelected(false);
        btnTRI_NOMcat.setSelected(false);
    }

    @FXML
    private void Filtre(ActionEvent event) {
        
        int m;
        CategoriesCrud c = new CategoriesCrud();
        m = c.appel_id_cat(CBCat1.getValue());
        String id_catstring = Integer.toString(m);
        id_cat1.setText(id_catstring);
        ProduitCRUD pc = new ProduitCRUD();

        List produits = pc.Filter2(c.appel_id_cat(CBCat1.getValue()));
        ObservableList list3 = FXCollections.observableArrayList(produits);
        tvProduit.setItems(list3);

       // tcIdprod.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcNomprod.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tcImageprod.setCellValueFactory(new PropertyValueFactory<>("image"));
        tcPrixprod.setCellValueFactory(new PropertyValueFactory<>("prix"));
        tcDescprod.setCellValueFactory(new PropertyValueFactory<>("description"));
        tcQteprod.setCellValueFactory(new PropertyValueFactory<>("qte"));
        cat_Id.setCellValueFactory(new PropertyValueFactory<>("cat_id"));
    }

    @FXML
    private void Image(ActionEvent event) {

        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        cheminimage.setText(filename);
        Image getAbsolutePath = null;
        ImageIcon icon = new ImageIcon(filename);
        if (f != null) {
            imageview.setImage(new Image(f.toURI().toString()));
        } else {
            System.out.println("erreur");
        }

    }

    @FXML
    private void triNomcat(ActionEvent event) {

        CategoriesCrud cc = new CategoriesCrud();
        if (btnTRI_NOMcat.isSelected()) {

            List categories = cc.afficherCategories2();
            ObservableList list = FXCollections.observableArrayList(categories);
            tvCat.setItems(list);
        } else {
            List categories = cc.afficherCategories();
            ObservableList list = FXCollections.observableArrayList(categories);
            tvCat.setItems(list);
        }
        tcNomCat.setCellValueFactory(new PropertyValueFactory<>("nom_c"));
    }

    @FXML
    private void rechercheCat(InputMethodEvent event) {

    }

    @FXML
    private void rechercheCat(KeyEvent event) {

        CategoriesCrud cc = new CategoriesCrud();
        if (!"".equals(RECHERCHE1.getText())) {
            List produits = cc.rechercheproduit(RECHERCHE1.getText());
            ObservableList list3 = FXCollections.observableArrayList(produits);
            tvCat.setItems(list3);
        } else {
            List produits = cc.afficherCategories();
            ObservableList list3 = FXCollections.observableArrayList(produits);
            tvCat.setItems(list3);
        }
        tcNomCat.setCellValueFactory(new PropertyValueFactory<>("nom_c"));
    }

    @FXML
    private void StatutfilterAction(ActionEvent event) {

        ReclamationCRUD cc = new ReclamationCRUD();
        if ("True".equals(Statutfilter.getValue())) {
            List reclamations = cc.afficherRecTrue();
            ObservableList list = FXCollections.observableArrayList(reclamations);
            tableview.setItems(list);
        } else {
            if ("False".equals(Statutfilter.getValue())) {
                List reclamations = cc.afficherRecFalse();
                ObservableList list = FXCollections.observableArrayList(reclamations);
                tableview.setItems(list);
            } else {
                List reclamations = cc.afficherRec();
                ObservableList list = FXCollections.observableArrayList(reclamations);
                tableview.setItems(list);
            }
        }

    }

    @FXML
    private void sujetreclamationfilter(ActionEvent event) {

        ReclamationCRUD cc = new ReclamationCRUD();
        if ("Tous".equals(sujetreclamation.getValue())) {
            List reclamations = cc.afficherRec();
            ObservableList list = FXCollections.observableArrayList(reclamations);
            tableview.setItems(list);
        } else {

            List reclamations = cc.afficherRecFilter(sujetreclamation.getValue());
            ObservableList list = FXCollections.observableArrayList(reclamations);
            tableview.setItems(list);

        }
    }

    @FXML
    private void rechercheRecl(InputMethodEvent event) {
    }

    @FXML
    private void rechercheRecl(KeyEvent event) {

        {
            ReclamationCRUD cc = new ReclamationCRUD();
            List reclamations = cc.afficherRecRecherche(rech.getText());
            ObservableList list = FXCollections.observableArrayList(reclamations);
            tableview.setItems(list);
        }

    }

    @FXML
    private void tristatutrec(ActionEvent event) {
        ReclamationCRUD cc = new ReclamationCRUD();
        if (btnTRI_prix1.isSelected()) {
            List reclamations = cc.TrierStatut();
            ObservableList list = FXCollections.observableArrayList(reclamations);
            tableview.setItems(list);
        } else {

            List reclamations = cc.afficherRec();
            ObservableList list = FXCollections.observableArrayList(reclamations);
            tableview.setItems(list);

        }
    }

    @FXML
    private void triEmailrec(ActionEvent event) {
        ReclamationCRUD cc = new ReclamationCRUD();
        if (btnTRI_prix11.isSelected()) {
            List reclamations = cc.TrierEmail();
            ObservableList list = FXCollections.observableArrayList(reclamations);
            tableview.setItems(list);
        } else {

            List reclamations = cc.afficherRec();
            ObservableList list = FXCollections.observableArrayList(reclamations);
            tableview.setItems(list);

        }
    }

    @FXML
    private void triNomrec(ActionEvent event) {
        ReclamationCRUD cc = new ReclamationCRUD();
        if (triNomrecbtn.isSelected()) {
            List reclamations = cc.TrierEmail();
            ObservableList list = FXCollections.observableArrayList(reclamations);
            tableview.setItems(list);
        } else {

            List reclamations = cc.afficherRec();
            ObservableList list = FXCollections.observableArrayList(reclamations);
            tableview.setItems(list);

        }
    }

    @FXML
    private void RedirectToMail(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("SendMail.fxml"));
        Parent root = loader.load();
        SendMailController ap = loader.getController();
        btnRependre.getScene().setRoot(root);

    }

    @FXML
    private void RedirectStat(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PieChart.fxml"));
        Parent root = loader.load();
        PieChartController ap = loader.getController();
        btnStat.getScene().setRoot(root);
    }

}
