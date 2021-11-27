package sk.fri.uniza.sporthealthsystem.module.fileMedia.mapper;

import org.springframework.jdbc.core.SqlReturnType;

import java.io.IOException;
import java.io.Reader;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.SQLException;

public class ClobToStringConverter implements SqlReturnType {
    public ClobToStringConverter() {
    }

    @Override
    public Object getTypeValue(CallableStatement cs,
                               int paramIndex, int sqlType, String typeName) throws SQLException {

        Clob aClob = cs.getClob(paramIndex);

        final Reader clobReader = aClob.getCharacterStream();

        int length = (int) aClob.length();
        char[] inputBuffer = new char[1024];
        final StringBuilder outputBuffer = new StringBuilder();
        try {
            while ((length = clobReader.read(inputBuffer)) != -1) {
                outputBuffer.append(inputBuffer, 0, length);
            }
        } catch (IOException e) {
            throw new SQLException(e.getMessage());
        }
        return outputBuffer.toString();
    }
}
