package org.example.Exceptions;

/**
 * Feb 2022
 * A 'homemade' Exception to report exceptions
 * arising in the Data Access Layer.
 */

import java.sql.SQLException;

import org.example.DTOs.Champ;

public class DaoException extends SQLException {
    public DaoException() {
        // not used
    }

    public DaoException(String aMessage) {
        super(aMessage);
    }
}
