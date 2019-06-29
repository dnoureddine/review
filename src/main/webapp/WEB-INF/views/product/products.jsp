<%@include file="../header.jsp" %>

<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
            
    <!-- Content header-->
    <section class="content-header">
        
          <!-- list save actions -->
          <%@include file="../saveActions.jsp" %>
          
          <h1>
               <spring:message code="label.products"/>
              <small></small>
           </h1>
    </section>
    
     <!--  Main Content -->
    <section class="content">
        
       <!-- Main Row -->
       <div class="row">   
	          <div class="col-md-12">
		          <div class="box box-info">
		            <div class="box-header">
		              <h3 class="box-title">
		                <small></small> 
		              </h3>
		              <!-- tools box -->
		              <div class="pull-right box-tools">
		                <button type="button" class="btn btn-info btn-sm" data-widget="collapse" data-toggle="tooltip" title="Collapse">
		                  <i class="fa fa-minus"></i></button>
		              </div>
		              <!-- /. tools -->
		            </div>
		            <!-- /.box-header -->
			            <div class="box-body pad">                      
         			          
			            </div>			    
		          </div>	          
		          <!-- /.box -->
		        </div>	                   
       </div><!-- ./Main Row -->
       
       
       
    </section>
    
    
  </div>
  

<%@include file="../footer.jsp" %>

