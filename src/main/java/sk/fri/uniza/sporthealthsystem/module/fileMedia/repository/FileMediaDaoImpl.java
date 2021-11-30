package sk.fri.uniza.sporthealthsystem.module.fileMedia.repository;

import oracle.jdbc.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.exception.NotFoundException;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.dto.DBFile;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.exception.MyFileNotFoundException;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.mapper.ClobToStringConverter;

import java.sql.SQLType;
import java.sql.Types;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class FileMediaDaoImpl implements FileMediaDao {

    private final FileMediaRepository fileMediaRepository;
    private final JdbcTemplate jdbcTemplate;
    protected SimpleJdbcCall simpleJdbcCall;

    @Autowired
    public FileMediaDaoImpl(FileMediaRepository fileMediaRepository, JdbcTemplate jdbcTemplate) {
        this.fileMediaRepository = fileMediaRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public DBFile findById(Long id) throws MyFileNotFoundException {
        return this.fileMediaRepository.findById(id)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + id));
    }

    @Override
    public DBFile save(DBFile file) {
        return this.fileMediaRepository.save(file);
    }

    public void deleteById(Long id) {
        this.fileMediaRepository.deleteById(id);
    }

    @Override
    public Optional<String> getJsonFromClob(String nameOfProcedure) {
        ClobToStringConverter clobConverter = new ClobToStringConverter();
        this.simpleJdbcCall  = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("get_js_json")
                .declareParameters(new SqlOutParameter("out_json", Types.CLOB,
                        null, new ClobToStringConverter()));

        Map<String, Object> returnMap =this.simpleJdbcCall.execute();

        return Optional.of(String.valueOf(returnMap.get("out_json")));
    }
}
