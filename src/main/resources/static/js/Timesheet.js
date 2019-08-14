

class Timesheet extends React.Component
{
	constructor(props)
	{
		super(props);
		this.state = {labor_info:[], machine_info:[]}
	}
	
	componentDidMount()
	{
		this.addLaborRow();
	}
	
	render()
	{
		let labor_rows_to_render = this.state.labor_info.map((elem) => TimeSheetRow(elem, "Machine Code: ", "Hours Worked: "));
		return(
			<div style={{padding:"30px"}}>
				<div id="labor_input_container" style={{boxSizing:"border-box", backgroundColor:"#EEEEEE", 
					borderStyle:"solid", borderColor:"#AAAAAA", margin:"20px"}}>
					<p style={{fontSize:"20px", padding:"10px"}}>Labor Entry</p>
					<ul style={{listStyleType:"none"}}>
						{labor_rows_to_render}
					</ul>
					<button style={{position:"absolute", right:"30px", margin:"20px"}} onClick={this.addLaborRow}>Add a Row</button>
							
				</div>	
				<button style={{margin:"30px", position:"relative", left:"20px"}} onClick={this.handleSubmit}>Submit</button>
			</div>
		)
	}
	
	addLaborRow = () =>
	{
		
		this.setState({
		  labor_info: [...this.state.labor_info, {"code":null, "hours":null, "total":null}]
		})
		console.log("adding a row")
	}
	addMachineRow = () =>
	{
		
		this.setState({
		  machine_info: [...this.state.machine_info, {"code":null, "hours":null, "total":null}]
		})
		console.log("adding a row")
	}
	
	handleSubmit = (e) =>
	{
		e.preventDefault();
		for(let i=0;i<this.state.labor_info.length;i++)
		{
			console.log(this.state.labor_info[i])
		}
		
	}
	
}



function TimeSheetRow (tsr, label1, label2)
{
	return(
		<React.Fragment>
		<li>
			<div style={{padding:"5px", paddingTop:"0px", float:"none"}}>
				<p style={{float:"left"}}>{label1}</p>
				<select style={{float:"left", padding:"1px"}} onChange={function (event){tsr["code"] = event.target.value;}}>
					<option value="opt1">opt1</option>
					<option value="opt2">opt2</option>
					<option value="opt3">opt3</option>
				</select>
				<form style={{float:"left", marginLeft:"50px", marginRight:"50px"}} onSubmit={function (e){e.preventDefault();}}>
					{label2}
					<input style={{paddingRight:"5px"}} type="number" 
					onChange={e => tsr["hours"] = e.target.value}
					/>
				</form>
				<form style={{height:"30px", paddingLeft:"100px"}} onSubmit={function (e){e.preventDefault();}}>
					Total:
					<input type="number" 
					onChange={e => tsr["total"] = e.target.value}
					/>
				</form>
			</div>
		</li>
		
		</React.Fragment>
	)
}

ReactDOM.render(
React.createElement(Timesheet),
document.getElementById('root')
);



