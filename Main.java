package test;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;

public class Main {

	public static void main(String[] args) {

		// Clusterオブジェクトを生成しておく
		Cluster cluster = null;

		try {

			// ドライバの窓口
			// CassandraCluster毎に単一のインスタンスを生成する
			// スレッドセーフで再利用する必要がある
			cluster = Cluster.builder()
								.addContactPoint("127.0.0.1")
								.build();

			// クエリの実行に使用する
			// スレッドセーフで再利用する必要がある
			Session session = cluster.connect();

			// セッションを使ってMappingManagerを生成する
			MappingManager manager = new MappingManager(session);

			// Mapperを生成
			// Tableアノテーションでアナウンスが必須
			Mapper<Faculties> mapper = manager.mapper(Faculties.class);

			// コンストラクタ引数に追加したいデータを入れる
			Faculties f = new Faculties(9, "Science", 200, 100);

			// データを保存する
			mapper.save(f);


			// 確認メッセージ
			System.out.println("正常にデータを追加できました");

		} finally {

			if (cluster != null) {
        cluster.close();

			}
		}
	}
}
