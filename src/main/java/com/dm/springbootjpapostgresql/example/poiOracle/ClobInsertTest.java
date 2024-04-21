package com.dm.springbootjpapostgresql.example.poiOracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClobInsertTest {
    
    private static final String SQL_INSERT = "insert into um_service_card_dummy (service_code, payment_method_and_options) values (?, ?)";
    
    //private static final String DATA = "<ul><li>Compensation is paid in cash if the damage is caused by external conditions, and if it is caused by the Land Department, compensation is made in cash up to two million AED, or compensation in kind if the value exceeds this amount.</li><li>If you want to swap a monetary compensation with a&nbsp; compensation in kind or vice versa, an application or petition is submitted for consideration by the higher authorities.</li><li>Compensation will be made for additional damage resulting from construction facilities, as well as for damages such as income allowance for work cessation periods, dismantling and removing and restoring costs, rental costs of temporary spaces covering the estimated time of cessation, this, after auditing the damages and checking the supporting documents by financial and technical specialists, upon agreement of the damaging party.</li><li>Damaged land is evaluated according to the average going price approved in each region and according to the specifications and building regulations at the time of evaluation.</li><li>An alternative land location is determined according to availability, the area, and the value of the land.</li><li>The Building Department will bear the demolition process costs  in the case of re-planning projects, while the damaging party will bear the demolition costs for other projects.</li><li>Dubai Municipality will guarantee compensation delivery  to the owners or beneficiaries if it undertakes all compensation procedures, while the party that caused the damage will be responsible for this if the Dubai Municipality procedures are limited to the evaluation process only.</li><li>In the event of the death of the owner or one of the heirs, the following procedures must be followed:</li><ul><li>Extracting a Legacy Notification Statement</li><li>Obtaining a Certificate of Ownership of the heirs' shares from the Land Department</li><li>Submitting the Certificate of Ownership to the Municipality&nbsp;</li><li>Valuation of the heirs' assets according to their legal shares</li><li>Issuing checks in the heirs' names of the amount of compensation</li><li>Handing each heir the amount of the compensation (in the form of a check)</li></ul><li>The subtenant does not have the right to receive any formal compensation as the compensation entitlement, from the Land and Property Department, is limited to the owner or the primary tenant,&nbsp;</li><li>Compensation for damaged land can be received after completion of the appraisal procedures and approval of compensation statements.</li><li>The appraisal procedures are completed after the appraisal committee meets and the committee's minutes are approved.</li><li>You have the right to file an objection regarding the valuation of the land.</li></ul>";

    private static final String DATA = "�� ������ ������ ���� ����";
    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:ORCL", "spring", "spring123");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {

            preparedStatement.setString(1, "3864");
            preparedStatement.setString(2, DATA);

            int row = preparedStatement.executeUpdate();

            // rows affected
            System.out.println(row); //1

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
