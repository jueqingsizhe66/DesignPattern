package f708.Connection;

import java.sql.SQLException;
import java.util.Date;

/*
商用级运用不能用此种方式  t_where???

使用解释器模式……

写自己的解析器

分析sql语句，形成AST，来真正实现翻译，减少漏洞

Druid 不错！
https://github.com/alibaba/druid/wiki/Druid_SQL_AST
https://github.com/alibaba/druid


金蝶公司内部语法转换器KSQL

温少(sql解析 AST）
http://www.iteye.com/magazines/90

 */
public class CatUtils {
	public static void checkSQL(String sql) throws SQLException {
		if (sql.startsWith("delete") && !sql.contains("where")) {
			throw new SQLException("Cannot delete records without sql!!!!!!");
		}
		if (sql.startsWith("update") && !sql.contains("where")) {
			throw new SQLException("Cannot update records without sql!!!!!!");
		}
	}

	public static void log(String sql) {
        /*
        可以用Log4j  记录下来 持久化
         */
		System.out.println(new Date(System.currentTimeMillis()) + ": " + sql);

	}
}
