// マッピング対象のクラスです
package test;


import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

// キースペース、カラムファミリの設定
@Table(keyspace = "blueuniv", name = "faculties",
readConsistency = "QUORUM",
writeConsistency = "QUORUM",
caseSensitiveKeyspace = false,
caseSensitiveTable = false)


public class Faculties {

		// パーティションキーの設定
		// プライマリーキーであるkeyを定義しておく
	  @PartitionKey
	  @Column(name = "key")
	  private int key;

		// カラム名を設定
		@ClusteringColumn
		private String name;
		private int students;
		private int teachers;


// Facultiesのコンストラクタを設定
public Faculties(int key, String name, int students, int teachers) {

		this.key = key;
		this.name = name;
		this.students = students;
		this.teachers = teachers;

}
}
