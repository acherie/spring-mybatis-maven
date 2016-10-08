package org.acherie.demo.dao.generator;

import java.util.List;
import org.acherie.demo.model.generator.Country;
import org.acherie.demo.model.generator.CountryExample;
import org.apache.ibatis.annotations.Param;

public interface CountryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table country
     *
     * @mbg.generated Sat Oct 08 08:10:25 CST 2016
     */
    long countByExample(CountryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table country
     *
     * @mbg.generated Sat Oct 08 08:10:25 CST 2016
     */
    int deleteByExample(CountryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table country
     *
     * @mbg.generated Sat Oct 08 08:10:25 CST 2016
     */
    int deleteByPrimaryKey(String code);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table country
     *
     * @mbg.generated Sat Oct 08 08:10:25 CST 2016
     */
    int insert(Country record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table country
     *
     * @mbg.generated Sat Oct 08 08:10:25 CST 2016
     */
    int insertSelective(Country record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table country
     *
     * @mbg.generated Sat Oct 08 08:10:25 CST 2016
     */
    List<Country> selectByExample(CountryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table country
     *
     * @mbg.generated Sat Oct 08 08:10:25 CST 2016
     */
    Country selectByPrimaryKey(String code);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table country
     *
     * @mbg.generated Sat Oct 08 08:10:25 CST 2016
     */
    int updateByExampleSelective(@Param("record") Country record, @Param("example") CountryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table country
     *
     * @mbg.generated Sat Oct 08 08:10:25 CST 2016
     */
    int updateByExample(@Param("record") Country record, @Param("example") CountryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table country
     *
     * @mbg.generated Sat Oct 08 08:10:25 CST 2016
     */
    int updateByPrimaryKeySelective(Country record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table country
     *
     * @mbg.generated Sat Oct 08 08:10:25 CST 2016
     */
    int updateByPrimaryKey(Country record);
}