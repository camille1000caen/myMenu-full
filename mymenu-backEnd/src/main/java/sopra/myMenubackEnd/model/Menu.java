package sopra.myMenubackEnd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "menu")
public class Menu {
		@Id
		@GeneratedValue
		@JsonView(Views.ViewCommon.class)
		private Long id;
		
		@Version
		@JsonView(Views.ViewCommon.class)
		private int version;
		
		@Column(name = "jour")
		@JsonView(Views.ViewCommon.class)
		private Date jour;
	
		@Column(name = "periode")
		@JsonIgnore
		private Integer periode;
		
		@OneToMany(mappedBy = "menu")
		@JsonIgnore
		private List<Repas> repas = new ArrayList<Repas>();
		
		@ManyToOne
		@JoinColumn(name = "planning_id")
		@JsonView(Views.ViewMenuWithPlanning.class)
		private Planning planning;
		
		//private final Duration = Duration.of(1, WEEKS);
		
		public Menu() {
			super();
		}
		
		public Menu(Integer periode) {
			super();
			this.periode = periode;
		}
		
		public Menu(Long id, Integer periode) {
			super();
			this.id = id;
			this.periode = periode;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
		

		public Date getJour() {
			return jour;
		}

		public void setJour(Date jour) {
			this.jour = jour;
		}

		public Integer getPeriode() {
			return periode;
		}

		public void setPeriode(Integer periode) {
			this.periode = periode;
		}

		public List<Repas> getRepas() {
			return repas;
		}

		public void setRepas(List<Repas> repas) {
			this.repas = repas;
		}

		public Planning getPlanning() {
			return planning;
		}

		public void setPlanning(Planning planning) {
			this.planning = planning;
		}	
			
		public int getVersion() {
			return version;
		}

		public void setVersion(int version) {
			this.version = version;
		}
}
